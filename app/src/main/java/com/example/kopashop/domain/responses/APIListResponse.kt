package com.example.kopashop.domain.responses

import com.google.gson.annotations.SerializedName

class APIListResponse<T>(
    @SerializedName("title")
    private val title: String,

    @SerializedName("material")
    private val material: String,

    @SerializedName("results")
    var data: List<T>?,

    @SerializedName("width")
    private val width: Int,

    @SerializedName("price")
    private val price: Int
) {
    fun getApiData(): List<T>{
        return data!!
    }
}