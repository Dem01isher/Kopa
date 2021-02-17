package com.example.kopashop.core.extensions

fun String.getDoubleValue(): Double {
    val parsedString: String = this.replace(",", ".")

    return if (parsedString.endsWith('.')) {
        parsedString.replace(".", "").toIntOrNull()?.toDouble() ?: 0.0
    } else {
        parsedString.toDoubleOrNull() ?: 0.0
    }
}