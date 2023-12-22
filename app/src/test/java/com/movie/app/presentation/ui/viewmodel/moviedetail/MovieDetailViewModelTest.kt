package com.movie.app.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import com.movie.app.presentation.ui.util.Constants.MOVIE_ID
import com.movie.app.utils.BaseTest
import com.movie.app.utils.FakeRepositoryImpl
import com.movie.domain.usecase.artist.MovieArtistUseCaseImpl
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCaseImpl
import io.mockk.clearAllMocks
import kotlinx.coroutines.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.* // ktlint-disable no-wildcard-imports
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class MovieDetailViewModelTest : BaseTest() {
    private lateinit var movieDetailsUseCase: MovieDetailsUseCaseImpl
    private lateinit var movieArtistUseCaseImpl: MovieArtistUseCaseImpl
    private lateinit var movieRepository: FakeRepositoryImpl
    private lateinit var viewModel: MovieDetailViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(mainCoroutineRule.dispatcherProvider.testCoroutineDispatcher)
        val savedState = SavedStateHandle(mapOf(MOVIE_ID to "951539"))
        MockitoAnnotations.initMocks(this)
        movieRepository = FakeRepositoryImpl()
        movieDetailsUseCase = MovieDetailsUseCaseImpl(movieRepository)
        movieArtistUseCaseImpl = MovieArtistUseCaseImpl(movieRepository)
        viewModel = MovieDetailViewModel(
            movieDetailsUseCase,
            movieArtistUseCaseImpl,
            testContextProvider,
            savedState,
        )
    }

    @Test
    fun getMovieDetailTest() = runTest {
        viewModel.movieState.collectLatest {
            assert(it.movie?.originalTitle == "Wonka")
            assert(it.movie?.status == "Released")
            assert(it.movie?.voteAverage == 7.2)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieArtistTest() = runTest {
        viewModel.artistState.collectLatest {
            if (it.cast.isEmpty().not() && it.crew.isEmpty().not()) {
                assert(it.cast.first().name == "Mike Kelson")
                assert(it.cast.first().creditId == "6236aa8a54a8ac0046db8c0b")
                assert(it.crew.first().gender == 2)
                assert(it.crew.first().job == "Executive Producer")
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainCoroutineRule.dispatcherProvider.testCoroutineDispatcher.cancel()
        clearAllMocks()
    }
}
