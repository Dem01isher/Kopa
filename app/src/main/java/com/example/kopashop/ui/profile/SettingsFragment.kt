package com.example.kopashop.presentation.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentSettingsBinding
import com.example.kopashop.presentation.menu.MenuFragment
import com.example.kopashop.utils.CircularTransformation
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso


class SettingsFragment : BaseBindingFragment<FragmentSettingsBinding>() {
    private lateinit var auth: FirebaseAuth


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        binding.tvNumber.text = currentUser?.phoneNumber
        binding.tvEmail1.text = currentUser?.email
        Picasso.get().load(currentUser?.photoUrl).transform(CircularTransformation())
            .into(binding.imageUser);

        binding.signOutBtn.setOnClickListener {
            auth.signOut()
            //findNavController().navigate(R.id.action_menuFragment_to_verificationFragment)
            Toast.makeText(context?.applicationContext, "Sign out", Toast.LENGTH_SHORT).show()
            binding.signOutBtn.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE

            ((parentFragment as NavHostFragment).parentFragment as MenuFragment).navigateToLogin()
        }

        binding.editProfileBtn.setOnClickListener {
            binding.relativeLayout.visibility = View.GONE
            binding.editProfileLayout.visibility = View.VISIBLE
            binding.imgUser.visibility = View.GONE
            binding.imgEditProfile.visibility = View.VISIBLE
        }

        binding.setEditBtn.setOnClickListener {
            binding.relativeLayout.visibility = View.VISIBLE
            binding.editProfileLayout.visibility = View.GONE
            binding.imgEditProfile.visibility = View.GONE
            binding.imgUser.visibility = View.VISIBLE
        }


    }

    override val layoutId: Int
        get() = R.layout.fragment_settings


}