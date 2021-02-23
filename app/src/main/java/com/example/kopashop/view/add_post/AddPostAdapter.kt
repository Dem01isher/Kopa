package com.example.kopashop.view.add_post

import com.bumptech.glide.Glide
import com.example.kopashop.R
import com.example.kopashop.core.recycler_view_adapter.BaseRecyclerViewAdapter
import com.example.kopashop.core.recycler_view_adapter.BindingHolder
import com.example.kopashop.databinding.FragmentAddPostBinding
import com.example.kopashop.domain.models.response.Boots
import com.example.kopashop.utils.BootsDiffCallback

class AddPostAdapter : BaseRecyclerViewAdapter<Boots, FragmentAddPostBinding>(BootsDiffCallback()) {
    override val layoutId: Int
        get() = R.layout.fragment_add_post

    override fun onBindViewHolder(holder: BindingHolder<FragmentAddPostBinding>, position: Int) {
        val item = getItem(holder.adapterPosition)

        holder.binding.etDescription.setText(item.description)
        Glide
            .with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.binding.image1)
        holder.binding.etPrice.setText(item.price.toString())
    }
}