package com.movie.app.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.movie.app.presentation.coroutinerule.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

open class BaseTest {
    val testContextProvider = TestContextProvider()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule(dispatcherProvider = testContextProvider)

    @get:Rule
    val instantTestExecutorRule = InstantTaskExecutorRule()
}
