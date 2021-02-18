package com.example.kopashop.data.repositories

import com.example.kopashop.data.source.remote.FirebaseDataSource
import com.example.kopashop.domain.repositories.BootsRepository
import com.example.kopashop.domain.models.response.Boots
import io.reactivex.Single

class BootsRepositoryImpl(private val firebaseDataSource: FirebaseDataSource) : BootsRepository {
    override fun getBoots(): Single<List<Boots>> = firebaseDataSource.getBoots()
}