package com.example.kopashop.data.source.remote

import com.example.kopashop.domain.responses.APIListResponse
import com.example.kopashop.domain.responses.BootsResponse
import io.reactivex.Single
import retrofit2.Retrofit

class RemoteDataSourceImpl(retrofit: Retrofit) : RemoteDataSource {
    private val api = retrofit.create(RemoteDataSource::class.java)

    override fun getBoots(): Single<APIListResponse<BootsResponse>> = api.getBoots()
}