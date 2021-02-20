package com.example.kopashop.view.about

import android.os.Bundle
import android.view.View
import com.example.kopashop.R
import com.example.kopashop.core.extensions.nonNullObserve
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentAboutBinding
import com.example.kopashop.view.boots.BootsViewModel
import timber.log.Timber
import kotlin.reflect.KClass

class AboutFragment : BaseVMFragment<BootsViewModel, FragmentAboutBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_about

    override val viewModelClass: KClass<BootsViewModel>
        get() = BootsViewModel::class

    private val adapter = AboutAdapter()


    //private val adapter = AboutAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d(arguments?.getString("boots_id"))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}