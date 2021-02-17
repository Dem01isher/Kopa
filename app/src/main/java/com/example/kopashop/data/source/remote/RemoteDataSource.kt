package com.example.kopashop.data.source.remote

import com.example.kopashop.domain.responses.APIListResponse
import com.example.kopashop.domain.responses.BootsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteDataSource {
    @GET("https://kopashop-796e5-default-rtdb.firebaseio.com/")
    fun getBoots(): Single<APIListResponse<BootsResponse>>
}