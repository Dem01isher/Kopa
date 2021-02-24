package com.example.kopashop.view.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentSettingsBinding
import com.example.kopashop.view.menu.MenuFragment
import com.google.firebase.auth.FirebaseAuth


class SettingsFragment : BaseBindingFragment<FragmentSettingsBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_settings

    private lateinit var auth: FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        binding.tvNumber.text = currentUser?.phoneNumber
        binding.tvEmail1.text = currentUser?.email

        Glide.with(this).load(currentUser?.photoUrl).transform(CircleCrop()).into(binding.imageUser)

        binding.signOutBtn.setOnClickListener {
            auth.signOut()
            //findNavController().navigate(R.id.action_menuFragment_to_verificationFragment)
            Toast.makeText(context?.applicationContext, "Sign out", Toast.LENGTH_SHORT).show()
            binding.signOutBtn.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE

            ((parentFragment as NavHostFragment).parentFragment as MenuFragment).navigateToLogin()
        }
    }
}