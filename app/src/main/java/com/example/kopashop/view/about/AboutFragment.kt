package com.example.kopashop.view.about

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentAboutBinding
import timber.log.Timber
import kotlin.reflect.KClass

class AboutFragment : BaseBindingFragment<FragmentAboutBinding>(), OnImageClickListener {

    override val layoutId: Int
        get() = R.layout.fragment_about

    private var imageList = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d(arguments?.getString("boots_id"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageAdapter = AboutAdapter(imageList, this)
        binding.ivAbout.adapter = imageAdapter
        imageAdapter.notifyDataSetChanged()



    }

    override fun onImageItemClicked(position: Int) {
        Toast.makeText(context?.applicationContext, "${imageList[position].image} Clicked", Toast.LENGTH_LONG).show()
    }

}