package com.example.kopashop.domain.models

data class BootsModel(
    var imageUrl: String = "",
    var title: String = "",
    var width: Int? = null,
    var price: Int? = null,
    var bootsLength: Int? = null,
    var material: String = "",
    var description: String = ""
)
