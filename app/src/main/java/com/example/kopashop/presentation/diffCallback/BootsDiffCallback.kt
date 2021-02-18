package com.example.kopashop.presentation.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.example.kopashop.domain.responses.BootsResponse
import com.example.kopashop.presentation.boots.Boots

class BootsDiffCallback : DiffUtil.ItemCallback<Boots>() {
    override fun areItemsTheSame(oldItem: Boots, newItem: Boots): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(oldItem: Boots, newItem: Boots): Boolean =
        oldItem == newItem
}