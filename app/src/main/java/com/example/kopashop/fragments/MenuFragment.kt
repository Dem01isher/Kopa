package com.example.kopashop.fragments


import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.kopashop.R
import com.example.kopashop.databinding.FragmentMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


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

    }


    fun setUpNavigation() {
        val nestedNavHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as? NavHostFragment
        val navController = nestedNavHostFragment?.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationMain,
                nestedNavHostFragment?.navController!!)

    }
}