package com.example.kopashop.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.databinding.FragmentVerifivactionBinding

class VerificationFragment: Fragment() {

    private lateinit var binding: FragmentVerifivactionBinding
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

        binding.icPhone.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_verifNumFragment)
        }

        binding.icFacebook.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_verifNumFragment)
        }

        binding.icGoogle.setOnClickListener {
            findNavController().navigate(R.id.action_verificationFragment_to_verifNumFragment)
        }
    }


}