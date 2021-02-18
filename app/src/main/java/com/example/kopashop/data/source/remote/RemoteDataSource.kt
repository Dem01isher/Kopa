package com.example.kopashop.data.source.remote

import com.example.kopashop.presentation.boots.Boots
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteDataSource {
    fun getBoots(): Single<List<Boots>>
}