package com.example.kopashop.view.about

import android.os.Bundle
import android.view.View
import com.example.kopashop.R
import com.example.kopashop.core.extensions.nonNullObserve
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentAboutBinding
import kotlin.reflect.KClass


class AboutFragment : BaseVMFragment<AboutViewModel, FragmentAboutBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_about

    override val viewModelClass: KClass<AboutViewModel>
        get() = AboutViewModel::class

    val adapter = AboutAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getBootsById(arguments?.getString("boots_id") ?: "")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserves()
    }

    private fun initObserves() {
        viewModel.bootsResponse.nonNullObserve(viewLifecycleOwner) {
            binding.item = it
        }
    }

}