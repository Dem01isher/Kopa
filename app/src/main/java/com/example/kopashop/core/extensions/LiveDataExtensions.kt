package com.example.kopashop.core.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.kopashop.core.event.Event

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer{
        it?.let(observer)
    })
}

fun <T> LiveData<Event<T>>.eventObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer {
        it?.let {
            it.getContentIfNotHandled()?.let(observer)
        }
    })
}