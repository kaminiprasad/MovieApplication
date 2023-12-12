package com.movie.app.presentation.ui.util

import androidx.navigation.NavBackStackEntry
import com.movie.app.presentation.navigation.Screen
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
