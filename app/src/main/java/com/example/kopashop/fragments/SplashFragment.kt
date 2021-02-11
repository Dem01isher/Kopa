package com.example.kopashop.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth


class SplashFragment : Fragment() {


    private lateinit var binding: FragmentSplashBinding
    // This property is only valid between onCreateView and
// onDestroyView.
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        Handler(Looper.getMainLooper())
                .postDelayed({
                    if(user != null) {
                        findNavController().navigate(R.id.action_splashFragment_to_menuFragment)
                    } else {
                        findNavController().navigate(R.id.action_splashFragment_to_verificationFragment)
                    }
                }, 3000)
    }

}

// findNavController().navigate(R.id.action_splashFragment_to_verificationFragment)