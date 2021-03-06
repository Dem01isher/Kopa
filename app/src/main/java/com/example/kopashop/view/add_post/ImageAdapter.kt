package com.example.kopashop.view.add_post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kopashop.core.recycler_view_adapter.BindingHolder
import com.example.kopashop.databinding.SecondImageBinding
import com.example.kopashop.databinding.SetImageBinding
import com.example.kopashop.domain.entity.ImageEntity

class ImageAdapter(private val onClick: (ImageEntity) -> Unit) :
    RecyclerView.Adapter<BindingHolder<*>>() {

    var list: List<ImageEntity> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<*> =
        when (viewType) {
           ViewType.BUTTON -> {
               BindingHolder(
                   SetImageBinding.inflate(
                       LayoutInflater.from(parent.context),
                       parent, false
                   )
               )
           }
           else -> BindingHolder(
               SecondImageBinding.inflate(
                   LayoutInflater.from(parent.context),
                   parent, false
               )
           )
       }

    override fun onBindViewHolder(holder: BindingHolder<*>, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is ImageEntity.SelectImage -> ViewType.BUTTON
            is ImageEntity.Image -> ViewType.SELECTED_IMAGE
        }
    }

    override fun getItemCount(): Int = list.size
}