package com.example.kopashop.data.repositories

import com.example.kopashop.data.source.remote.FirebaseDataSource
import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.repositories.BootsRepository
import com.example.kopashop.domain.response.Boots
import io.reactivex.Completable
import io.reactivex.Single

class BootsRepositoryImpl(private val firebaseDataSource: FirebaseDataSource) : BootsRepository {
    override fun getBoots(): Single<List<Boots>> = firebaseDataSource.getBoots()
    override fun getBootsById(id: String): Single<Boots> = firebaseDataSource.getBootsById(id)
    override fun createBoots(boots: BootsModel): Completable = firebaseDataSource.createBoots(boots)

}