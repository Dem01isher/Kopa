package com.example.kopashop.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.databinding.FragmentVerifivactionBinding
import com.facebook.*
import com.facebook.FacebookSdk.getApplicationContext
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class VerificationFragment: Fragment() {

    private lateinit var binding: FragmentVerifivactionBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var mCallbackManager: CallbackManager
    // This property is only valid between onCreateView and
// onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVerifivactionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FacebookSdk.sdkInitialize(getApplicationContext());

        auth = FirebaseAuth.getInstance()

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create()

        binding.icFacebook.setReadPermissions("email", "public_profile")
        binding.icFacebook.registerCallback(mCallbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {
            }

            override fun onError(error: FacebookException) {
            }
        })


        binding.icPhone.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_verifNumFragment)
        }
        /*
        binding.icFacebook.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_verifNumFragment)

        }
         */

        binding.icGoogle.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_verifNumFragment)
        }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(context, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }

                // ...
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        if(user != null){
            findNavController().navigate(R.id.action_verificationFragment_to_verifNumFragment)
        } else {
            Toast.makeText(context, "Please sign in to continue.", Toast.LENGTH_SHORT).show()
        }

    }
}