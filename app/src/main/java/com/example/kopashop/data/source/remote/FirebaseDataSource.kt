package com.example.kopashop.data.source.remote

import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.response.Boots
import io.reactivex.Completable
import io.reactivex.Single

interface FirebaseDataSource {
    fun getBoots(): Single<List<Boots>>
    fun getBootsById(id: String) : Single<Boots>
    fun createBoots(boots: BootsModel) : Completable
}