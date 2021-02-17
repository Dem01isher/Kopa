package com.example.kopashop.ui.menu


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kopashop.R
import com.example.kopashop.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    // This property is only valid between onCreateView and
// onDestroyView.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpNavigation()
        val bottomNavigableView = binding.bottomNavigationMain

        binding.ivAdd.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_addPostFragment)
        }



    }


    fun setUpNavigation() {
        val nestedNavHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as? NavHostFragment
        val navController = nestedNavHostFragment?.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationMain,
                nestedNavHostFragment?.navController!!)

    }

    fun navigateToLogin() {
        findNavController().navigate(R.id.action_menuFragment_to_verificationFragment)
    }
}