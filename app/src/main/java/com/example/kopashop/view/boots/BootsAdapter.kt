package com.example.kopashop.view.boots

import com.bumptech.glide.Glide
import com.example.kopashop.R
import com.example.kopashop.core.recycler_view_adapter.BaseRecyclerViewAdapter
import com.example.kopashop.core.recycler_view_adapter.BindingHolder
import com.example.kopashop.databinding.ListLayoutBinding
import com.example.kopashop.domain.models.response.Boots
import com.example.kopashop.utils.BootsDiffCallback

class BootsAdapter() :
    BaseRecyclerViewAdapter<Boots, ListLayoutBinding>(BootsDiffCallback()) {

    override val layoutId: Int
        get() = R.layout.list_layout

    private var onClickListener: ((String) -> Unit)? = null

    override fun onBindViewHolder(holder: BindingHolder<ListLayoutBinding>, position: Int) {
        val item = getItem(holder.adapterPosition)


        holder.binding.title.text = item.title
        holder.binding.price.text = item.price.toString()
        holder.binding.bootsLength.text = item.bootsLength.toString()
        holder.binding.width.text = item.width.toString()
        holder.binding.materialTitle.text = item.material
        // Check BootsResponse

        holder.binding.root.setOnClickListener {
            onClickListener?.invoke(item.id)
        }

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.binding.image)
    }

    fun setOnClickListener(listener: (String) -> Unit) {
        onClickListener = listener
    }


}