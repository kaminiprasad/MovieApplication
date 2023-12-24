package com.movie.app.presentation.ui.viewmodel.popularmovie

import com.movie.app.utils.* // ktlint-disable no-wildcard-imports
import com.movie.domain.entity.movie.Movie
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
                assert(it.first().title == "Trolls Band Together")
                assert(it.first().voteAverage == 6.3)
            }
        }
    }

    private fun getPopularMovies() =
        listOf(
            Movie(
                id = 897087,
                title = "Trolls Band Together",
                originalTitle = "Trolls Band Together",
                backdropPath = "/zIYROrkHJPYB3VTiW1L9QVgaQO.jpg",
                posterUrl = "/zDb5YeHSGGMlS6eqhUXcVU2OzAJ.jpg",
                voteAverage = 6.3,
                releaseDate = "2023-10-05",
            ),
            Movie(
                id = 466420,
                title = "Killers of the Flower Moon",
                originalTitle = "Killers of the Flower Moon",
                backdropPath = "/1X7vow16X7CnCoexXh4H4F2yDJv.jpg",
                posterUrl = "/dB6Krk806zeqd0YNp2ngQ9zXteH.jpg",
                voteAverage = 7.687,
                releaseDate = "2023-10-18",
            ),
            Movie(
                id = 901362,
                title = "Freelance",
                originalTitle = "Freelance",
                backdropPath = "/k1KrbaCMACQiq7EA0Yhw3bdzMv7.jpg",
                posterUrl = "/sEaLO9s7CIN3fjz8R3Qksum44en.jpg",
                voteAverage = 7.150,
                releaseDate = "2023-10-12",
            ),
        )

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
