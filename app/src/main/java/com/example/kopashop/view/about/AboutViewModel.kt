package com.example.kopashop.view.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kopashop.core.view_model.BaseViewModel
import com.example.kopashop.domain.response.BootsResponse
import com.example.kopashop.domain.repositories.BootsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class AboutViewModel(private val bootsRepository: BootsRepository) : BaseViewModel() {
    private val _boots = MutableLiveData<BootsResponse>()
    val bootsResponse: LiveData<BootsResponse> = _boots

    fun getBootsById(id: String) {
        disposables + bootsRepository.getBootsById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    _boots.postValue(it)
                },
                onError = {
                    timber.log.Timber.d(it)
                }
            )

    }
}