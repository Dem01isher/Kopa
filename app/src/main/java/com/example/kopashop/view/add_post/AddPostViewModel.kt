package com.example.kopashop.view.add_post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kopashop.core.view_model.BaseViewModel
import com.example.kopashop.domain.models.response.Boots
import com.example.kopashop.domain.repositories.BootsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class AddPostViewModel(private val apiRepository: BootsRepository) : BaseViewModel() {

}