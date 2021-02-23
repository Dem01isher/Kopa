package com.example.kopashop.data.source.remote

import com.example.kopashop.domain.models.response.Boots
import io.reactivex.Single

interface FirebaseDataSource {
    fun getBoots(): Single<List<Boots>>
    fun getBootsById(id: String) : Single<Boots>
    fun setBootsById(id: String) : Single<Boots>
}