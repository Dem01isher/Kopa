package com.example.kopashop.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.kopashop.R
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        val navControl = fragmentContainer.findNavController()
        AppBarConfiguration(setOf(R.id.dataFragment, R.id.galleryFragment, R.id.settingsFragment))


        bottom_navigation_main.setupWithNavController(navControl)
        */

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)


    }
}