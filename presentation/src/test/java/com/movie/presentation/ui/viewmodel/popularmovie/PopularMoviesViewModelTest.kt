package com.movie.presentation.ui.viewmodel.popularmovie

import com.movie.domain.extension.Result
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import com.movie.presentation.ui.mapper.DomainMovieToPresentationMapperImpl
import com.movie.presentation.ui.model.MoviesLoaded
import com.movie.presentation.utils.TROLLS_BAND_TOGETHER
import com.movie.presentation.utils.TROLLS_VOTE_AVERAGE
import com.movie.presentation.utils.getPopularMovies
import com.movie.presentation.utils.getPopularMoviesPresentation
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
        val expectedResult = Result.Success(getPopularMovies())
        coEvery { useCase() } returns expectedResult
        coEvery { mapperImpl.map(getPopularMovies()) } returns getPopularMoviesPresentation()

        val viewModel = PopularMoviesViewModel(mapperImpl, useCase)
        // When
        runTest {
            viewModel.getMovieList()
        }

        // Then
        val result = viewModel.movieState.value
        result as MoviesLoaded
        Assert.assertTrue(result.data.isEmpty().not())
        assert(result.data.first().title == TROLLS_BAND_TOGETHER)
        assert(result.data.first().voteAverage == TROLLS_VOTE_AVERAGE)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
