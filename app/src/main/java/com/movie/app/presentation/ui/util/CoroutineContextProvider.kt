package com.movie.app.presentation.ui.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

open class CoroutineContextProvider @Inject constructor() {
    open val IO: CoroutineDispatcher by lazy { Dispatchers.IO }
}
