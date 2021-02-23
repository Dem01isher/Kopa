package com.example.kopashop.view.add_post

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentAddPostBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlin.reflect.KClass


class AddPostFragment : BaseVMFragment<AddPostViewModel,FragmentAddPostBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_add_post

    override val viewModelClass: KClass<AddPostViewModel>
        get() = AddPostViewModel::class

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.save.setOnClickListener {
        }
    }

}