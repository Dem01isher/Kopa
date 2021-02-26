package com.example.kopashop.data.repositories

import com.example.kopashop.data.source.remote.FirebaseDataSource
import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.repositories.BootsRepository
import com.example.kopashop.domain.response.BootsResponse
import io.reactivex.Completable
import io.reactivex.Single

class BootsRepositoryImpl(private val firebaseDataSource: FirebaseDataSource) : BootsRepository {
    override fun getBoots(): Single<List<BootsResponse>> = firebaseDataSource.getBoots()
    override fun getBootsById(id: String): Single<BootsResponse> = firebaseDataSource.getBootsById(id)
    override fun createBoots(boots: BootsModel): Completable = firebaseDataSource.createBoots(boots)

}