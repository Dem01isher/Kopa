package com.example.kopashop.presentation.register

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentRegisterBinding

class RegisterFragment : BaseBindingFragment<FragmentRegisterBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_menuFragment)
        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_register

}