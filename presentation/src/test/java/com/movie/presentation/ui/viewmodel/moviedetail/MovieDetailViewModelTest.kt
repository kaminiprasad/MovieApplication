package com.movie.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import com.movie.data.util.Constants
import com.movie.domain.entity.artist.Artist
import com.movie.domain.extension.Result
import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import com.movie.presentation.ui.mapper.DomainArtistToPresentationMapperImpl
import com.movie.presentation.ui.mapper.MovieDetailToPresentationMapperImpl
import com.movie.presentation.ui.model.DomainArtistToPresentationModel
import com.movie.presentation.ui.util.Constants.MOVIE_ID
import com.movie.presentation.ui.util.CoroutineContextProvider
import com.movie.presentation.utils.ARTIST_ID
import com.movie.presentation.utils.MIKE_KELSON
import com.movie.presentation.utils.MIKE_KELSON_PROFILE_PATH
import com.movie.presentation.utils.MOVIE_DETAIL_TITLE
import com.movie.presentation.utils.MOVIE_DETAIL_VOTE_AVERAGE
import com.movie.presentation.utils.SCOTT_CHAMBERS
import com.movie.presentation.utils.SCOTT_CHAMBERS_PROFILE_PATH
import com.movie.presentation.utils.getMovieCast
import com.movie.presentation.utils.getMovieCastPresentation
import com.movie.presentation.utils.getMovieCrew
import com.movie.presentation.utils.getMovieCrewPresentation
import com.movie.presentation.utils.getMovieDetail
import com.movie.presentation.utils.getMovieDetailPresentation
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

const val MOVIE_ARTIST_ID = "951539"

@ExperimentalCoroutinesApi
class MovieDetailViewModelTest {
    private val artistMapper: DomainArtistToPresentationMapperImpl = mockk()
    private val mapper: MovieDetailToPresentationMapperImpl = mockk()
    private val movieDetailUseCase: MovieDetailsUseCase = mockk()
    private val artistUseCase: MovieArtistUseCase = mockk()
    private lateinit var testDispatcher: TestDispatcher
    private lateinit var savedStateHandle: SavedStateHandle
    private val contextProvider: CoroutineContextProvider = mockk()
    private lateinit var viewModel: MovieDetailViewModel

    @Before
    fun setUp() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
        savedStateHandle = SavedStateHandle(mapOf(MOVIE_ID to MOVIE_ARTIST_ID))
        viewModel = MovieDetailViewModel(
            artistMapperImpl = artistMapper,
            mapperImpl = mapper,
            movieDetails = movieDetailUseCase,
            movieArtist = artistUseCase,
            contextProvider = contextProvider,
            savedStateHandle = savedStateHandle,
        )
    }

    @Test
    fun `GIVEN a movie detail WHEN a movie with particular id is requested THEN the movie detail is returned`() {
        // Given
        val expectedResult = Result.Success(getMovieDetail())
        coEvery { movieDetailUseCase(MOVIE_ARTIST_ID.toInt()) } returns expectedResult
        coEvery { artistUseCase(MOVIE_ARTIST_ID.toInt()) } returns Result.Error(Constants.EXCEPTION_UNKNOWN_ERROR)
        coEvery { mapper.map(getMovieDetail()) } returns getMovieDetailPresentation()
        coEvery { contextProvider.IO } returns testDispatcher

        // When
        runTest {
            viewModel.loadMovieDetailData()
        }

        // Then
        val result = viewModel.movieState.value
        assert(result.movie?.originalTitle == MOVIE_DETAIL_TITLE)
        assert(result.movie?.title == MOVIE_DETAIL_TITLE)
        assert(result.movie?.voteAverage == MOVIE_DETAIL_VOTE_AVERAGE)
    }

    @Test
    fun `GIVEN a movie WHEN artist's crew and cast are requested THEN the movie artist details are returned`() {
        // Given
        val movieArtist = Artist(
            cast = getMovieCast(),
            crew = getMovieCrew(),
            id = ARTIST_ID,
        )
        val movieArtistPresentation = DomainArtistToPresentationModel(
            cast = getMovieCastPresentation(),
            crew = getMovieCrewPresentation(),
            id = ARTIST_ID,
        )

        val expectedResult = Result.Success(movieArtist)
        coEvery { artistUseCase(MOVIE_ARTIST_ID.toInt()) } returns expectedResult
        coEvery { movieDetailUseCase(MOVIE_ARTIST_ID.toInt()) } returns Result.Error(Constants.EXCEPTION_UNKNOWN_ERROR)

        coEvery { artistMapper.map(movieArtist) } returns movieArtistPresentation
        coEvery { contextProvider.IO } returns testDispatcher

        // When
        runTest {
            viewModel.loadMovieDetailData()
        }

        // Then
        val result = viewModel.artistState.value
        Assert.assertTrue(result.cast.isEmpty().not())
        Assert.assertTrue(result.crew.isEmpty().not())
        assert(result.cast.first().name == MIKE_KELSON)
        assert(result.cast.first().profilePath == MIKE_KELSON_PROFILE_PATH)
        assert(result.crew.first().name == SCOTT_CHAMBERS)
        assert(result.crew.first().profilePath == SCOTT_CHAMBERS_PROFILE_PATH)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
