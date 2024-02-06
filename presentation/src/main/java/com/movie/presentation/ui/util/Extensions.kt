package com.movie.presentation.ui.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.navigation.NavBackStackEntry
import com.movie.presentation.navigation.Screen
import java.math.RoundingMode
import java.text.DecimalFormat

fun Double.roundOff(): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(this).toDouble().toString()
}

fun NavBackStackEntry?.isMovieDetailPage() =
    this?.destination?.route?.substringBeforeLast(
        "/",
    ).equals(Screen.MovieItemDetail.route)

fun Context.isInternetConnectionAvailable(): Boolean {
    var isAvailable = false
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    connectivityManager.allNetworks.forEach { network ->
        val networkCapability = connectivityManager.getNetworkCapabilities(network)

        networkCapability?.let {
            if (it.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                isAvailable = true
                return@forEach
            }
        }
    }
    return isAvailable
}
