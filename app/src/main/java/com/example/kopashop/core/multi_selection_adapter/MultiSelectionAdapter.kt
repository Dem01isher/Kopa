package com.example.kopashop.core.multi_selection_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.kopashop.core.recycler_view_adapter.BindingHolder
import com.example.kopashop.presentation.diffCallback.BootsDiffCallback

abstract class MultiSelectionAdapter<T, Binding: ViewDataBinding>(
    private val onClick: (T) -> Unit,
    private val permanentSelecting: Boolean = false,
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BindingHolder<Binding>>(diffCallback) {
    protected abstract val layoutId: Int

    private val multiSelectionCallback: MultiSelectionCallback? = null
    private var maxSize: Int? = null

    private var isSelectingMode: Boolean = false
    private val selectedItems = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<Binding> =
        BindingHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
        )

    override fun onBindViewHolder(holder: BindingHolder<Binding>, position: Int) {
        val item = getItem(holder.adapterPosition)

        if (selectedItems.contains(item)) {
            itemSelected(holder)
        } else {
            itemNotSelected(holder)
        }

        initListeners(holder, item)
    }

    private fun initListeners(holder: BindingHolder<Binding>, item: T) {
        holder.binding.root.setOnClickListener{
            if (!isSelectingMode) {
                onClick(item)
            } else {
                if (selectedItems.contains(item)) {
                    selectedItems.remove(item)

                    multiSelectionCallback?.selectionSize(selectedItems.size)

                    animateItemDeselected(holder)
                    if(selectedItems.isEmpty() && !permanentSelecting) {
                        isSelectingMode = false

                        multiSelectionCallback?.selectionDisable()
                    }
                } else {
                    if (maxSize != null) {
                        if (selectedItems.size < maxSize!!) {
                            selectedItems.add(item)

                            multiSelectionCallback?.selectionSize(selectedItems.size)

                            animateItemSelected(holder)
                        } else {
                            multiSelectionCallback?.selectionLimit()
                        }
                    } else {
                        selectedItems.add(item)

                        multiSelectionCallback?.selectionSize(selectedItems.size)

                        animateItemSelected(holder)
                    }
                }
            }
        }
        if (!permanentSelecting) {
            holder.binding.root.setOnLongClickListener {
                if (!isSelectingMode) {

                    multiSelectionCallback?.selectionEnable()

                    isSelectingMode = true

                    selectedItems.add(item)

                    multiSelectionCallback?.selectionSize(selectedItems.size)

                    animateItemSelected(holder)
                    return@setOnLongClickListener true
                }
                return@setOnLongClickListener false
            }
        }
    }


    abstract fun itemSelected(holder: BindingHolder<Binding>)
    abstract fun itemNotSelected(holder: BindingHolder<Binding>)

    abstract fun animateItemSelected(holder: BindingHolder<Binding>)
    abstract fun animateItemDeselected(holder: BindingHolder<Binding>)
}