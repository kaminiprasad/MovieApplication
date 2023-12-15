package com.movie.app.presentation.ui.viewmodel.popularmovie

import com.movie.app.utils.* // ktlint-disable no-wildcard-imports
import com.movie.domain.usecase.popularmovie.PopularMovieUseCaseImpl
import io.mockk.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.* // ktlint-disable no-wildcard-imports
import org.junit.* // ktlint-disable no-wildcard-imports
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class PopularMoviesViewModelTest : BaseTest() {

    private lateinit var popularMoviesUseCase: PopularMovieUseCaseImpl
    private lateinit var movieRepository: FakeRepositoryImpl
    private lateinit var viewModel: PopularMoviesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieRepository = FakeRepositoryImpl()
        popularMoviesUseCase = PopularMovieUseCaseImpl(movieRepository)
        viewModel = PopularMoviesViewModel(popularMoviesUseCase, testContextProvider)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieTest() = runTest {
        viewModel.movieState.collectLatest {
            if (it.isEmpty().not()) {
                assert(it.first().title == "Trolls Band Together")
                assert(it.first().voteAverage == 6.3)
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
