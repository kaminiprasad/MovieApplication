package com.movie.data.util

import com.movie.data.util.Constants.EMPTY

fun String?.notEmpty() = if (this.isNullOrEmpty()) EMPTY else this
