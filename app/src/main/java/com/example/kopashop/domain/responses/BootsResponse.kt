package com.example.kopashop.domain.responses

import com.google.gson.annotations.SerializedName

data class BootsResponse(
        @SerializedName("title_id")
        val titleIds: List<Int>? = listOf(),
        val id: Int? = 0,
        @SerializedName("price_id")
        val priceId: List<Int> = listOf(),

)