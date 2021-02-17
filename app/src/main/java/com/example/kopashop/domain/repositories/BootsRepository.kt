package com.example.kopashop.domain.repositories

import com.example.kopashop.domain.responses.APIListResponse
import com.example.kopashop.domain.responses.BootsResponse
import io.reactivex.Single

interface BootsRepository {
    fun getBoots() : Single<APIListResponse<BootsResponse>>
}