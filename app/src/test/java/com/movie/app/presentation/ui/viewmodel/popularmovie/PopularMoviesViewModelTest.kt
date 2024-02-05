package com.movie.app.presentation.ui.viewmodel.popularmovie

import com.movie.app.presentation.ui.mapper.DomainMovieToPresentationMapperImpl
import com.movie.app.utils.TROLLS_BAND_TOGETHER
import com.movie.app.utils.TROLLS_VOTE_AVERAGE
import com.movie.app.utils.getPopularMovies
import com.movie.app.utils.getPopularMoviesPresentation
import com.movie.domain.extension.Result
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PopularMoviesViewModelTest {

    private val useCase: PopularMovieUseCase = mockk()
    private val mapperImpl: DomainMovieToPresentationMapperImpl = mockk()
    private lateinit var testDispatcher: TestDispatcher

    @Before
    fun setUp() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `GIVEN list of movies as input WHEN movie items are requested THEN the movie list is returned`() {
        // Given
        val viewModel = PopularMoviesViewModel(mapperImpl, useCase)
        val expectedResult = Result.Success(getPopularMovies())
        coEvery { useCase() } returns expectedResult

        coEvery { mapperImpl.map(getPopularMovies()) } returns getPopularMoviesPresentation()

        // When
        runTest {
            viewModel.getMovieList()
        }

        // Then
        val result = viewModel.movieState.value
        Assert.assertTrue(result.isEmpty().not())
        assert(result.first().title == TROLLS_BAND_TOGETHER)
        assert(result.first().voteAverage == TROLLS_VOTE_AVERAGE)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
