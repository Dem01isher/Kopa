package com.example.kopashop.domain.repositories

import com.example.kopashop.domain.responses.APIListResponse
import com.example.kopashop.domain.responses.BootsResponse
import com.example.kopashop.presentation.boots.Boots
import io.reactivex.Single

interface BootsRepository {
    fun getBoots() : Single<List<Boots>>
}