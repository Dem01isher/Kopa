package com.example.kopashop.view.list


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.kopashop.R
import com.example.kopashop.core.extensions.nonNullObserve
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.view.boots.BootsAdapter
import com.example.kopashop.view.boots.BootsViewModel
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
        adapter.setOnClickListener {
            (parentFragment as NavHostFragment)
                .parentFragment
                ?.findNavController()
                ?.navigate(R.id.action_menuFragment_to_aboutFragment2, bundleOf("boots_id" to it))
        }

        viewModel.bootsResponse.nonNullObserve(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getBoots()
        }

    }
}
