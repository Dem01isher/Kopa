package com.example.kopashop.view.active_archive

import android.os.Bundle
import android.view.View
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.databinding.FragmentSecondBinding
import com.example.kopashop.view.boots.BootsViewModel
import com.google.android.material.tabs.TabLayout
import kotlin.reflect.KClass

class SecondFragment : BaseBindingFragment<FragmentSecondBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_second


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Active"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Cricket"))

        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = fragmentManager?.let {
            ArchiveAdapter(
                requireContext(), it,
                binding.tabLayout.tabCount
            )
        }
        binding.viewPager.adapter = adapter
        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


}