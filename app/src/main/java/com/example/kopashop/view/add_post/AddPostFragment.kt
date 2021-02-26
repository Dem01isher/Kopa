package com.example.kopashop.view.add_post

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kopashop.R
import com.example.kopashop.core.extensions.nonNullObserve
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentAddPostBinding
import com.example.kopashop.domain.entity.ImageEntity
import com.example.kopashop.domain.models.BootsModel
import kotlin.reflect.KClass


class AddPostFragment : BaseVMFragment<AddPostViewModel, FragmentAddPostBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_add_post

    override val viewModelClass: KClass<AddPostViewModel>
        get() = AddPostViewModel::class

    private val adapter : ImageAdapter = ImageAdapter {}
    private val image = listOf(
        ImageEntity.SelectImage, ImageEntity.Image(),
        ImageEntity.Image(), ImageEntity.Image(), ImageEntity.Image(),
        ImageEntity.Image(), ImageEntity.Image(), ImageEntity.Image()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        initObserves()

        binding.selectImage.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.selectImage.adapter = adapter
        adapter.list = image

        binding.selectImage.setOnClickListener {

        }

        binding.save.setOnClickListener {
            viewModel.createBoots(
                BootsModel(
                    description = binding.etDescription.text.toString(),
                    material = binding.spinnerMaterial.selectedItemPosition.toString(),
                    price = binding.etPrice.text.toString().toInt(),
                    title = binding.etModel.text.toString(),
                    width = binding.spinnerWidth.selectedItemPosition.toString().toInt(),
                    bootsLength = binding.spinnerLength.selectedItemPosition.toString().toInt(),
                )
            )
        }
    }

    private fun initObserves() {
        viewModel.boots.nonNullObserve(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
    }

}