package com.example.kopashop.view.active_archive

import android.os.Bundle
import android.view.View
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.ListLayoutBinding
import com.example.kopashop.view.boots.BootsViewModel
import kotlin.reflect.KClass

class ThirdFragment : BaseVMFragment<BootsViewModel, ListLayoutBinding>() {

    override val viewModelClass: KClass<BootsViewModel>
        get() = BootsViewModel::class
    override val layoutId: Int
        get() = R.layout.fragment_third


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}