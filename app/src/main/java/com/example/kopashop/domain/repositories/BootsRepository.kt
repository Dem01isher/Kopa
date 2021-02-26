package com.example.kopashop.domain.repositories

import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.response.BootsResponse
import io.reactivex.Completable
import io.reactivex.Single

interface BootsRepository {
    fun getBoots() : Single<List<BootsResponse>>
    fun getBootsById(id: String) : Single<BootsResponse>
    fun createBoots(boots: BootsModel) : Completable
}