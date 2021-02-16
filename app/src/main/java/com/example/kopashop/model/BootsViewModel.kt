package com.example.kopashop.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BootsViewModel : ViewModel() {

    var bootsList: MutableLiveData<List<Boots>> = MutableLiveData()

    init {
        bootsList.value = BootsData.getBoots()
    }

    fun getListBoots() = bootsList

    fun updateListBoots() {
        bootsList.value = BootsData.getBoots()
    }
}