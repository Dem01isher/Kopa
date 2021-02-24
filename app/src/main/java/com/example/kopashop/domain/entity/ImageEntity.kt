package com.example.kopashop.domain.entity

sealed class ImageEntity{
    object SelectImage: ImageEntity()
    data class Image(
        var imageUrl: String = ""
    ) : ImageEntity()
}
