package com.example.kopashop.view.add_post

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.databinding.FragmentAddPostBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class AddPostFragment : BaseBindingFragment<FragmentAddPostBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_add_post

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.save.setOnClickListener {

        }
    }

    fun saveFireStore() {
        val db = FirebaseFirestore.getInstance()
        val boots: MutableMap<String, Any> = HashMap()
        //boots["imageUrl"] = binding.image1.
        boots["description"] = binding.etDescription.text.toString()
        boots["price"] = binding.etPrice.text.toString().toInt()
        boots["material"] = binding.spinnerMaterial.selectedItem.toString()
        boots["title"] = binding.spinnerModel.selectedItem.toString()

        db.collection("shoes")
            .add(boots)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "record added successfully ", Toast.LENGTH_SHORT ).show()
            }
            .addOnFailureListener{
                Toast.makeText(requireContext(), "record Failed to add ", Toast.LENGTH_SHORT ).show()
            }

    }

}