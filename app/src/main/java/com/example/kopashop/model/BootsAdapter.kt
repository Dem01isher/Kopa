package com.example.kopashop.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kopashop.R

class BootsAdapter : RecyclerView.Adapter<BootsAdapter.BootsHolder>() {

    private var boots: List<Boots> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BootsHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_layout,
            parent,
            false
        )
        return BootsHolder(itemView)
    }

    override fun onBindViewHolder(holder: BootsHolder, position: Int) {
        holder.bind(boots[position])
    }

    fun refreshList(boots: List<Boots>){
        this.boots = boots
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = boots.size

    class BootsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var bootsTitle: TextView
        lateinit var sizeBoots: TextView
        lateinit var imageView: ImageView
        lateinit var price: TextView
        lateinit var material: TextView
        lateinit var bootsLength: TextView

        init {
            bootsTitle = itemView.findViewById(R.id.bootsTitle)
            sizeBoots = itemView.findViewById(R.id.sizeBoots)
            imageView = itemView.findViewById(R.id.imageView)
            price = itemView.findViewById(R.id.price)
            material = itemView.findViewById(R.id.materialTitle)
            bootsLength = itemView.findViewById(R.id.lengthBoot)
        }

        fun bind(boots: Boots) = with(itemView) {
            boots.title = bootsTitle.text.toString()
            boots.material = material.text.toString()
            boots.price = price.text.toString()
            boots.length = bootsLength.text.toString()
        }
    }
}