package com.example.kopashop.domain.response

data class BootsResponse(
    var imageUrl: String = "",
    var title: String = "",
    var width: Int? = null,
    var price: Int? = null,
    var bootsLength: Int? = null,
    var material: String = "",
    var description: String = "",
    var id: String
)