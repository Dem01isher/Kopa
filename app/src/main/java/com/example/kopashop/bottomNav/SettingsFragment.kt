package com.example.kopashop.bottomNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.kopashop.R
import com.example.kopashop.databinding.FragmentSettingsBinding
import com.google.firebase.auth.FirebaseAuth


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        //binding.tvTown.text = currentUser?.
        binding.numberTxt.text = currentUser?.phoneNumber
        Glide.with(this).load(currentUser?.photoUrl).into(binding.imageUser)

        binding.signOutBtn.setOnClickListener {
            auth.signOut()
            //findNavController().navigate(R.id.action_menuFragment_to_verificationFragment)
            Toast.makeText(context?.applicationContext, "Sign out", Toast.LENGTH_SHORT).show()
            binding.signOutBtn.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }

    }


}