package com.example.kopashop.data.repositories

import com.example.kopashop.data.source.remote.RemoteDataSource
import com.example.kopashop.domain.repositories.BootsRepository
import com.example.kopashop.domain.responses.APIListResponse
import com.example.kopashop.domain.responses.BootsResponse
import io.reactivex.Single

class BootsRepositoryImpl(private val remoteDataSource: RemoteDataSource) : BootsRepository {
    override fun getBoots(): Single<APIListResponse<BootsResponse>> = remoteDataSource.getBoots()
}