package com.example.kopashop.presentation.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.example.kopashop.domain.responses.BootsResponse

class BootsDiffCallback : DiffUtil.ItemCallback<BootsResponse>() {
    override fun areItemsTheSame(oldItem: BootsResponse, newItem: BootsResponse): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: BootsResponse, newItem: BootsResponse): Boolean =
        oldItem == newItem
}