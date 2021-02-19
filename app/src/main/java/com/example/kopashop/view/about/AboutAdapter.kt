package com.example.kopashop.view.about

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kopashop.R
import com.example.kopashop.core.recycler_view_adapter.BaseRecyclerViewAdapter
import com.example.kopashop.core.recycler_view_adapter.BindingHolder
import com.example.kopashop.databinding.ItemPageBinding
import com.example.kopashop.domain.models.response.Boots
import com.example.kopashop.utils.BootsDiffCallback

class AboutAdapter(private val images: ArrayList<Image>, private val onImageClickListener: OnImageClickListener) : BaseRecyclerViewAdapter<Boots, ItemPageBinding>(BootsDiffCallback()) {
    override val layoutId: Int
        get() = R.layout.item_page

    override fun onBindViewHolder(holder: BindingHolder<ItemPageBinding>, position: Int) {
        val image = images[position]
        val item = getItem(holder.adapterPosition)

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.binding.ivPage)

    }


}