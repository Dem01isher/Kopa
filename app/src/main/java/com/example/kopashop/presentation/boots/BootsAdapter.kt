package com.example.kopashop.presentation.boots

import androidx.appcompat.view.menu.ListMenuItemView
import com.bumptech.glide.Glide
import com.example.kopashop.R
import com.example.kopashop.core.recycler_view_adapter.BaseRecyclerViewAdapter
import com.example.kopashop.core.recycler_view_adapter.BindingHolder
import com.example.kopashop.databinding.ListLayoutBinding
import com.example.kopashop.domain.responses.BootsResponse
import com.example.kopashop.presentation.diffCallback.BootsDiffCallback

class BootsAdapter(onClick: (BootsResponse) -> Unit) :
        BaseRecyclerViewAdapter<BootsResponse, ListLayoutBinding>(BootsDiffCallback()) {

        override val layoutId: Int
                get() = R.layout.list_layout

        override fun onBindViewHolder(holder: BindingHolder<ListLayoutBinding>, position: Int) {
                val item = getItem(holder.adapterPosition)
                holder.binding.bootsTitle.text = item.titleIds?.size.toString()
                // Check BootsResponse
                Glide.with(holder.itemView.context)
                        .load("https://sportspage-feeds.p.rapidapi.com/games")
                        .into(holder.binding.imageView)
        }
}