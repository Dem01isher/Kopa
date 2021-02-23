package com.example.kopashop.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.kopashop.domain.response.Boots

class BootsDiffCallback : DiffUtil.ItemCallback<Boots>() {
    override fun areItemsTheSame(oldItem: Boots, newItem: Boots): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(oldItem: Boots, newItem: Boots): Boolean =
        oldItem == newItem
}