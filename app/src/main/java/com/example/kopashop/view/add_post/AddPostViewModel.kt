package com.example.kopashop.view.add_post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kopashop.core.view_model.BaseViewModel
import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.repositories.BootsRepository
import com.example.kopashop.domain.response.Boots
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class AddPostViewModel(private val apiRepository: BootsRepository) : BaseViewModel() {

    fun createBoots(boots: BootsModel) {
        disposables + apiRepository.createBoots(boots)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                //onSuccess = {

                //},
                onError = {
                    timber.log.Timber.d(it)
                }
            )

    }
}