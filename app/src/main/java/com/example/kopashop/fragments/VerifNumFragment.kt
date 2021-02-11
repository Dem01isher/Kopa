package com.example.kopashop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.databinding.FragmentVerifNumBinding


class VerifNumFragment : Fragment() {

    private lateinit var binding: FragmentVerifNumBinding
// onDestroyView.

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentVerifNumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.vrfBtn.setOnClickListener {
            findNavController().navigate(R.id.action_verifNumFragment_to_registerFragment)
        }

    }





}