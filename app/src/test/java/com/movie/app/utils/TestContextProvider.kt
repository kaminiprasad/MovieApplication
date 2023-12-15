package com.movie.app.utils

import com.movie.app.presentation.ui.util.CoroutineContextProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher

class TestContextProvider : CoroutineContextProvider() {

    @OptIn(ExperimentalCoroutinesApi::class)
    val testCoroutineDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    override val IO: CoroutineDispatcher
        get() = testCoroutineDispatcher

    @OptIn(ExperimentalCoroutinesApi::class)
    override val Main: CoroutineDispatcher
        get() = testCoroutineDispatcher

    @OptIn(ExperimentalCoroutinesApi::class)
    override val Default: CoroutineDispatcher
        get() = testCoroutineDispatcher

    @OptIn(ExperimentalCoroutinesApi::class)
    override val Unconfined: CoroutineDispatcher
        get() = testCoroutineDispatcher
}
