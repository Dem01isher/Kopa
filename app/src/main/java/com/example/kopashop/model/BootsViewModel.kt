package com.example.kopashop.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BootsViewModel : ViewModel() {

    private val bootsList = MutableLiveData<List<Boots>>()

    init {
        bootsList.postValue(BootsData.getBoots())
    }

    fun getListBoots() : LiveData<List<Boots>> = bootsList

    fun updateListBoots() {
        bootsList.postValue(BootsData.getBoots())
    }
}