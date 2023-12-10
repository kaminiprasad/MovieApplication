package com.reachout.data.util

fun String?.notNull() = if (this.isNullOrEmpty()) "" else this