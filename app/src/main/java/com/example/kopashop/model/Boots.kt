package com.example.kopashop.model

import com.google.firebase.database.Exclude

data class Boots(
    var title: String = "",
    var width: Int = 0,
    var price: Int = 0,
    var length: Int = 0,
    var material: String = ""
) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "title" to title,
            "width" to width,
            "price" to price,
            "length" to length,
            "material" to material
        )
    }
}