package com.movie.app.presentation.ui.viewmodel.popularmovie

import com.movie.app.presentation.ui.mapper.DomainMovieToPresentationMapperImpl
import com.movie.app.utils.* // ktlint-disable no-wildcard-imports
import com.movie.domain.extension.Result
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import io.mockk.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.* // ktlint-disable no-wildcard-imports
import org.junit.* // ktlint-disable no-wildcard-imports

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
    fun `GIVEN list of movies as input WHEN movie items are requested THEN the movie list is returned`() =
        runTest {
            // Given
            val expectedResult = Result.Success(getPopularMovies())
            coEvery { useCase() } returns flowOf(expectedResult)

            coEvery { mapperImpl.map(getPopularMovies()) } returns getPopularMoviesPresentation()

            // When
            val viewModel = PopularMoviesViewModel(mapperImpl, useCase)
            viewModel.getMovieList()

            // Then
            viewModel.movieState.collectLatest {
                if (it.isEmpty().not()) {
                    assert(it.first().title == TROLLS_BAND_TOGETHER)
                    assert(it.first().voteAverage == TROLLS_VOTE_AVERAGE)
                }
            }
        }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
