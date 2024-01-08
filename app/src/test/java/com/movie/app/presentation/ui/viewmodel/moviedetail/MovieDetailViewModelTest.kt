package com.movie.app.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import com.movie.app.presentation.ui.util.Constants.MOVIE_ID
import com.movie.app.utils.* // ktlint-disable no-wildcard-imports
import com.movie.domain.entity.artist.Artist
import com.movie.domain.extension.Result
import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.* // ktlint-disable no-wildcard-imports
import org.junit.After
import org.junit.Before
import org.junit.Test

const val MOVIE_ARTIST_ID = "951539"

class MovieDetailViewModelTest {
    private val movieDetailUseCase: MovieDetailsUseCase = mockk()
    private val artistUseCase: MovieArtistUseCase = mockk()
    private lateinit var testDispatcher: TestDispatcher
    private lateinit var savedStateHandle: SavedStateHandle

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
        savedStateHandle = SavedStateHandle(mapOf(MOVIE_ID to MOVIE_ARTIST_ID))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieDetailTest() = runTest {
        val expectedResult = Result.Success(getMovieDetail())
        coEvery { movieDetailUseCase(MOVIE_ARTIST_ID.toInt()) } returns flowOf(expectedResult)

        // When
        val viewModel = MovieDetailViewModel(
            movieDetails = movieDetailUseCase,
            movieArtist = artistUseCase,
            savedStateHandle = savedStateHandle,
        )
        viewModel.getMovieById(MOVIE_ARTIST_ID.toInt())

        // Then
        viewModel.movieState.collectLatest {
            assert(it.movie?.originalTitle == MOVIE_DETAIL_TITLE)
            assert(it.movie?.status == MOVIE_DETAIL_STATUS)
            assert(it.movie?.voteAverage == MOVIE_DETAIL_VOTE_AVERAGE)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieArtistTest() = runTest {
        val movieArtist = Artist(
            cast = getMovieCast(),
            crew = getMovieCrew(),
            id = ARTIST_ID,
        )

        val expectedResult = Result.Success(movieArtist)
        coEvery { artistUseCase(MOVIE_ARTIST_ID.toInt()) } returns flowOf(expectedResult)

        // When
        val viewModel = MovieDetailViewModel(
            movieDetails = movieDetailUseCase,
            movieArtist = artistUseCase,
            savedStateHandle = savedStateHandle,
        )
        viewModel.movieCredit(MOVIE_ARTIST_ID.toInt())

        // Then
        viewModel.artistState.collectLatest {
            if (it.cast.isEmpty().not() && it.crew.isEmpty().not()) {
                assert(it.cast.first().name == MIKE_KELSON)
                assert(it.cast.first().creditId == MIKE_KELSON_CREDIT_ID)
                assert(it.crew.first().gender == MALE)
                assert(it.crew.first().job == EXECUTIVE_PRODUCER)
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
