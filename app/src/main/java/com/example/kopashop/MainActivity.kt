package com.example.kopashop


import android.os.Bundle
import com.example.kopashop.core.activity.BaseBindingActivity

import com.example.kopashop.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*
        val bottomNavigableView = findViewById<BottomNavigationView>(R.id.bottom_navigation_main)
        val navController = findNavController(R.id.fragment)
        bottomNavigableView.setupWithNavController(navController)
        */
    }

    override val layoutId: Int
        get() = R.layout.activity_main
}