package com.example.kopashop.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kopashop.R
import com.example.kopashop.databinding.ListLayoutBinding

class BootsAdapter(var postListItem: List<Boots>) : RecyclerView.Adapter<BootsAdapter.BootsHolder>() {

    class BootsHolder(val binding: ListLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    private var boots: List<Boots> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BootsHolder {
        return BootsHolder(ListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BootsHolder, position: Int) {

    }

    fun refreshList(boots: List<Boots>) {
        this.boots = boots
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = boots.size

}


