package com.example.kopashop.core.extensions

import android.R
import android.animation.LayoutTransition
import android.os.SystemClock
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup

fun View.visible() {
    if (visibility == View.VISIBLE) return
    visibility = View.VISIBLE
}

fun View.gone() {
    if (visibility == View.GONE) return
    visibility = View.GONE
}

fun View.invisible() {
    if (visibility == View.INVISIBLE) return
    visibility = View.INVISIBLE
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.disableClick() {
    isClickable = false
}

fun View.enableClick() {
    isClickable = true
}

fun View.isVisible() = visibility == View.VISIBLE
fun View.isGone() = visibility == View.GONE
fun View.isInvisible() = visibility == View.INVISIBLE

fun View.switchVisibility() {
    if (isVisible()) {
        gone()
    } else {
        visible()
    }
}

fun View.setOnClickWithDebounce(debounceTime: Long = 600L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}


fun ViewGroup.enableTransition() {
    layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
}

fun View.addRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

fun View.addCircleRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(R.attr.selectableItemBackgroundBorderless, this, true)
    setBackgroundResource(resourceId)
}