package com.movie.app.presentation.coroutinerule

import com.movie.app.utils.TestContextProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class MainCoroutineRule(
    private val dispatcher: TestDispatcher = StandardTestDispatcher(),
    var dispatcherProvider: TestContextProvider = TestContextProvider(),
) :
    TestWatcher() {
//    private val singleThreadExecutor = Executors.newSingleThreadExecutor()

    override fun starting(description: Description) {
        super.starting(description)
//        Dispatchers.setMain(singleThreadExecutor.asCoroutineDispatcher())
        Dispatchers.setMain(dispatcherProvider.testCoroutineDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
//        singleThreadExecutor.shutdownNow()
        Dispatchers.resetMain()
    }
}
