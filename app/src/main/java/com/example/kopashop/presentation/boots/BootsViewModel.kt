package com.example.kopashop.presentation.boots

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kopashop.core.view_model.BaseViewModel
import com.example.kopashop.domain.repositories.BootsRepository
import com.example.kopashop.domain.responses.BootsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class BootsViewModel(private val apiRepository: BootsRepository) : BaseViewModel() {
    private val _boots = MutableLiveData<List<BootsResponse>>()
    val boots: LiveData<List<BootsResponse>> = _boots

    init {
        getBoots()
    }
    fun getBoots() {
        disposables + apiRepository.getBoots()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    _boots.postValue(it.getApiData())
                },
                onError = {}
            )

    }
}