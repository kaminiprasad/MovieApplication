package com.movie.app.presentation.ui.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

open class CoroutineContextProvider @Inject constructor() {
    open val IO: CoroutineDispatcher by lazy { Dispatchers.IO }
    open val Main: CoroutineDispatcher by lazy { Dispatchers.Main }
    open val Default: CoroutineDispatcher by lazy { Dispatchers.Default }
    open val Unconfined: CoroutineDispatcher by lazy { Dispatchers.Unconfined }
}
