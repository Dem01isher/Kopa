package com.example.kopashop.ui.about

import android.os.Bundle
import android.view.View
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentAboutBinding

class AboutFragment : BaseBindingFragment<FragmentAboutBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_about

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}