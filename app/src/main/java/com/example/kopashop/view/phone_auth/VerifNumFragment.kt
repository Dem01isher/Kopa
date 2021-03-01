package com.example.kopashop.view.phone_auth

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentVerifNumBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit


class VerifNumFragment : BaseBindingFragment<FragmentVerifNumBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_verif_num

    private lateinit var auth: FirebaseAuth
    private lateinit var verifyId: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()


        binding.vrfBtn.setOnClickListener {
            //findNavController().navigate(R.id.action_verifNumFragment_to_registerFragment)
            if (validateMobile(binding.textInputNumber.text.toString())) {
                signIn()
                binding.textInputNumber.visibility = View.GONE
                binding.vrfBtn.visibility = View.GONE

                binding.verifyNumber.visibility = View.VISIBLE
                binding.btnNext.visibility = View.VISIBLE
            }
        }

        binding.btnNext.setOnClickListener {
            verifyCode(binding.verifyNumber.text.toString())

            binding.verifyNumber.visibility = View.GONE
            binding.btnNext.visibility = View.GONE
            binding.enter.visibility = View.GONE
            binding.ellipse.visibility = View.GONE
            binding.imgLogo.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE

            findNavController().navigate(R.id.action_verifNumFragment_to_menuFragment)
        }

    }

    private fun validateMobile(input: String): Boolean {
        if (input.isNotEmpty() && Patterns.PHONE.matcher(binding.textInputNumber.text.toString())
                .matches()
        ) {
            Toast.makeText(
                context?.applicationContext,
                "Validated Successfully",
                Toast.LENGTH_SHORT
            ).show()
            return true
        } else {
            Toast.makeText(context?.applicationContext, "Invalid phone number", Toast.LENGTH_SHORT)
                .show()
            return false
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val user = task.result?.user
                    // ...
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                }
            }
    }

    private fun signIn() {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(binding.textInputNumber.text.toString())
            .setTimeout(30L, TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onCodeSent(
                    verificationId: String,
                    forceResendingToken: PhoneAuthProvider.ForceResendingToken
                ) {
                    verifyId = verificationId
                }

                override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                    val code = phoneAuthCredential.smsCode
                    if (code != null) {
                        verifyCode(code)
                    } else {
                        signInWithPhoneAuthCredential(phoneAuthCredential)
                    }
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    // ...
                }
            })
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        auth.setLanguageCode("ua")
    }

    private fun verifyCode(code: String) {
        if (verifyId.isNotEmpty()) {
            val credential = PhoneAuthProvider.getCredential(verifyId, code)
            signInWithPhoneAuthCredential(credential)
        }
    }
}