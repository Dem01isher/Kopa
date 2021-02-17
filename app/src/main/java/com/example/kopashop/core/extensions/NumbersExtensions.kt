package com.example.kopashop.core.extensions

import java.lang.StringBuilder
import java.text.DecimalFormat

fun Double.decimalFormat(split: Boolean = true): String {
    val decimalFormat = DecimalFormat("###.##")
    val formattedString = decimalFormat.format(this).replace(",", ".")

    return if (split) {
        val startIndex =
            if (formattedString.contains('.')) formattedString.indexOf('.') else formattedString.length
        val result: StringBuilder =
            StringBuilder(formattedString.subSequence(startIndex, formattedString.length))

        if (startIndex > 3) {
            for (i in startIndex - 3 downTo 0 step 3) {
                result.insert(0, formattedString.substring(i, i + 3))
                if (i >= 3) {
                    result.insert(0, " ")
                } else {
                    result.insert(0, "${formattedString.substring(0, i)} ")
                }
            }
        } else {
            result.insert(0, formattedString.substring(0, startIndex))
        }

        result.toString()
    } else {
        formattedString
    }
}

fun Double.defaultFormat(): String {
    val decimalFormat = DecimalFormat("0")
    decimalFormat.maximumFractionDigits = 8
    return (decimalFormat.format(this))
}