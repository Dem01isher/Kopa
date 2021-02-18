package com.example.kopashop.core.extensions

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun SwipeRefreshLayout.showRefresh(){
    this.isRefreshing = true
}

fun SwipeRefreshLayout.hideRefresh(){
    this.isRefreshing = false
}