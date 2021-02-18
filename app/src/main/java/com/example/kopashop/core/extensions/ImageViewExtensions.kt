package com.example.kopashop.core.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import java.io.File

fun ImageView.displayImage(photoUrl: String) {
//    GlideApp.with(context)
//        .load(photoUrl)
//        .into(this)
}

fun ImageView.displayImage(photoFile: File) {

}

fun ImageView.displayImage(@DrawableRes photoDrawable: Int) {

}