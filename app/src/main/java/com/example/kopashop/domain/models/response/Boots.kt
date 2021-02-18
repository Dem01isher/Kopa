package com.example.kopashop.domain.models.response

data class Boots(
    var imageUrl: String = "",
    var title: String = "",
    var width: Int? = null,
    var price: Int? = null,
    var bootsLength: Int? = null,
    var material: String = ""
)