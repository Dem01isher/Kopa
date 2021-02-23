package com.example.kopashop.view.about

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kopashop.R
import com.example.kopashop.core.recycler_view_adapter.BaseRecyclerViewAdapter
import com.example.kopashop.core.recycler_view_adapter.BindingHolder
import com.example.kopashop.databinding.FragmentAboutBinding
import com.example.kopashop.databinding.ItemPageBinding
import com.example.kopashop.domain.models.response.Boots
import com.example.kopashop.utils.BootsDiffCallback

class AboutAdapter() : BaseRecyclerViewAdapter<Boots, FragmentAboutBinding>(BootsDiffCallback()) {
    override val layoutId: Int
        get() = R.layout.fragment_about

    override fun onBindViewHolder(holder: BindingHolder<FragmentAboutBinding>, position: Int) {

        val item = getItem(holder.adapterPosition)
        holder.binding.title.text = item.title
        holder.binding.bootsLength.text = item.bootsLength.toString()
        holder.binding.material.text = item.material
        holder.binding.price.text = item.price.toString()
        holder.binding.width.text = item.width.toString()
        holder.binding.description.text = item.description

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.binding.ivAbout)

    }
}