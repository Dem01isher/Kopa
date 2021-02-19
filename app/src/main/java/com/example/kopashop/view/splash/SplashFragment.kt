package com.example.kopashop.presentation.splash

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth


class SplashFragment : BaseBindingFragment<FragmentSplashBinding>() {


    override val layoutId: Int
        get() = R.layout.fragment_splash

    private lateinit var auth: FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        val connMgr = activity
            ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = connMgr.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {

            binding.imgLogo.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
            binding.tvLoading.visibility = View.GONE

            Handler(Looper.getMainLooper())
                .postDelayed({
                    if (user != null) {
                        findNavController().navigate(R.id.action_splashFragment_to_menuFragment)
                    } else {
                        findNavController().navigate(R.id.action_splashFragment_to_verificationFragment)
                    }
                }, 3000)
        } else {
            binding.imgLogo.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            binding.tvLoading.visibility = View.VISIBLE
        }
    }


}

// findNavController().navigate(R.id.action_splashFragment_to_verificationFragment)