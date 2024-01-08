package com.movie.app.presentation.ui.viewmodel.popularmovie

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

@OptIn(ExperimentalCoroutinesApi::class)
class PopularMoviesViewModelTest {

    private val useCase: PopularMovieUseCase = mockk()
    private lateinit var testDispatcher: TestDispatcher

    @Before
    fun setUp() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieTest() = runTest {
        // Given
        val expectedResult = Result.Success(getPopularMovies())
        coEvery { useCase() } returns flowOf(expectedResult)

        // When
        val viewModel = PopularMoviesViewModel(useCase)
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
