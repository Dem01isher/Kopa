package com.example.kopashop.ui.splash

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
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