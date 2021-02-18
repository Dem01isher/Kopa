package com.example.kopashop.data.repositories

import com.example.kopashop.data.source.remote.RemoteDataSource
import com.example.kopashop.domain.repositories.BootsRepository
import com.example.kopashop.presentation.boots.Boots
import io.reactivex.Single

class BootsRepositoryImpl(private val remoteDataSource: RemoteDataSource) : BootsRepository {
    override fun getBoots(): Single<List<Boots>> = remoteDataSource.getBoots()
}