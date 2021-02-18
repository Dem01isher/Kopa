package com.example.kopashop.ui.list


import android.os.Bundle
import android.view.View
import com.example.kopashop.R
import com.example.kopashop.core.extensions.nonNullObserve
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.ui.boots.BootsAdapter
import com.example.kopashop.ui.boots.BootsViewModel
import kotlin.reflect.KClass


class FirstFragment : BaseVMFragment<BootsViewModel, FragmentFirstBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_first
    override val viewModelClass: KClass<BootsViewModel>
        get() = BootsViewModel::class

    private val adapter: BootsAdapter = BootsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listView.adapter = adapter

        viewModel.boots.nonNullObserve(viewLifecycleOwner){
            adapter.submitList(it)
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getBoots()
        }

    }
}
