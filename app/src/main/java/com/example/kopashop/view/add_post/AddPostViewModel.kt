package com.example.kopashop.view.add_post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kopashop.core.view_model.BaseViewModel
import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.repositories.BootsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class AddPostViewModel(private val bootsRepository: BootsRepository) : BaseViewModel() {

    private val _boots = MutableLiveData<Unit>()
    val boots : LiveData<Unit> = _boots

    fun createBoots(boots: BootsModel) {
        disposables + bootsRepository.createBoots(boots)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onComplete = {
                    _boots.postValue(Unit)
                },
                onError = {
                    timber.log.Timber.d(it)
                }
            )

    }
}