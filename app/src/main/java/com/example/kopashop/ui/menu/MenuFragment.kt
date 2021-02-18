package com.example.kopashop.ui.menu


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentMenuBinding


class MenuFragment : BaseBindingFragment<FragmentMenuBinding>() {


    // This property is only valid between onCreateView and
// onDestroyView.


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpNavigation()
        val bottomNavigableView = binding.bottomNavigationMain

        binding.ivAdd.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_addPostFragment)
        }

    }

    fun setUpNavigation() {
        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.fragment) as? NavHostFragment
        val navController = nestedNavHostFragment?.navController
        NavigationUI.setupWithNavController(
            binding.bottomNavigationMain,
            nestedNavHostFragment?.navController!!
        )

    }

    fun navigateToLogin() {
        findNavController().navigate(R.id.action_menuFragment_to_verificationFragment)
    }

    override val layoutId: Int
        get() = R.layout.fragment_menu
}