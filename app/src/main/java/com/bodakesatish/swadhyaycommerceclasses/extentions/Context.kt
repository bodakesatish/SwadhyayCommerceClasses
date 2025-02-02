package com.bodakesatish.swadhyaycommerceclasses.extentions

import android.content.Context
import android.net.ConnectivityManager

fun Context.isConnectedToNetwork(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return connectivityManager?.activeNetworkInfo?.isConnected ?: false
}