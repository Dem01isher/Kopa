package com.example.kopashop.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.databinding.FragmentSecondBinding
import com.example.kopashop.ui.boots.BootsViewModel
import kotlin.reflect.KClass

class SecondFragment : BaseVMFragment<BootsViewModel, FragmentFirstBinding>() {

    override val viewModelClass: KClass<BootsViewModel>
        get() = BootsViewModel::class
    override val layoutId: Int
        get() = R.layout.fragment_second


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}