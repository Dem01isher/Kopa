package com.example.kopashop.domain.repositories

import com.example.kopashop.domain.models.response.Boots
import io.reactivex.Single

interface BootsRepository {
    fun getBoots() : Single<List<Boots>>
}