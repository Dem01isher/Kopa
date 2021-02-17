package com.example.kopashop.core.multi_selection_adapter

abstract class MultiSelectionCallback {
    abstract fun selectionEnable()
    abstract fun selectionDisable()
    abstract fun selectionSize(currentSize: Int)
    abstract fun selectionLimit()
}