package com.example.kopashop.presentation.boots

import android.os.Bundle
import android.view.View
import androidx.compose.ui.node.getOrAddAdapter
import com.example.kopashop.R
import com.example.kopashop.core.extensions.nonNullObserve
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentBootsBinding
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.databinding.ListLayoutBinding
import kotlin.reflect.KClass

class BootsFragment : BaseVMFragment<BootsViewModel, FragmentFirstBinding>() {

    private val adapter: BootsAdapter = BootsAdapter ()

    override val viewModelClass: KClass<BootsViewModel>
        get() = BootsViewModel::class
    override val layoutId: Int
        get() = R.layout.list_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserves()
        binding.listView.adapter = adapter
    }

    private fun initObserves() {
        viewModel.boots.nonNullObserve(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }
}