package com.movie.data.util

fun String?.notNull() = if (this.isNullOrEmpty()) "" else this