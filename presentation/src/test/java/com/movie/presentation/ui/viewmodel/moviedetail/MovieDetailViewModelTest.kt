package com.movie.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import com.movie.domain.extension.Result
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import com.movie.presentation.ui.mapper.MovieDetailToPresentationMapperImpl
import com.movie.presentation.ui.model.MovieDetailLoaded
import com.movie.presentation.ui.util.Constants.MOVIE_ID
import com.movie.presentation.utils.MOVIE_ARTIST_ID
import com.movie.presentation.utils.MOVIE_DETAIL_TITLE
import com.movie.presentation.utils.MOVIE_DETAIL_VOTE_AVERAGE
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
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieDetailViewModelTest {
    private val mapper: MovieDetailToPresentationMapperImpl = mockk()
    private val movieDetailUseCase: MovieDetailsUseCase = mockk()
    private lateinit var testDispatcher: TestDispatcher
    private val savedStateHandle: SavedStateHandle = mockk()
    private lateinit var viewModel: MovieDetailViewModel

    @Before
    fun setUp() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `GIVEN a movie detail WHEN a movie with particular id is requested THEN the movie detail is returned`() {
        // Given
        val expectedResult = Result.Success(getMovieDetail())
        coEvery { savedStateHandle.get<String>(MOVIE_ID) } returns MOVIE_ARTIST_ID
        coEvery { movieDetailUseCase(MOVIE_ARTIST_ID.toInt()) } returns expectedResult
        coEvery { mapper.map(getMovieDetail()) } returns getMovieDetailPresentation()

        viewModel = MovieDetailViewModel(
            mapperImpl = mapper,
            movieDetails = movieDetailUseCase,
            savedStateHandle = SavedStateHandle(mapOf(MOVIE_ID to MOVIE_ARTIST_ID)),
        )

        // When
        runTest {
            viewModel.getMovieById(MOVIE_ARTIST_ID.toInt())
        }

        // Then
        val result = viewModel.movieState.value
        result as MovieDetailLoaded
        assert(result.movie.originalTitle == MOVIE_DETAIL_TITLE)
        assert(result.movie.title == MOVIE_DETAIL_TITLE)
        assert(result.movie.voteAverage == MOVIE_DETAIL_VOTE_AVERAGE)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
