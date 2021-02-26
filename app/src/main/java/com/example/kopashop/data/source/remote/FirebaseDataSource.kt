package com.example.kopashop.data.source.remote

import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.response.BootsResponse
import io.reactivex.Completable
import io.reactivex.Single

interface FirebaseDataSource {
    fun getBoots(): Single<List<BootsResponse>>
    fun getBootsById(id: String) : Single<BootsResponse>
    fun createBoots(boots: BootsModel) : Completable
}