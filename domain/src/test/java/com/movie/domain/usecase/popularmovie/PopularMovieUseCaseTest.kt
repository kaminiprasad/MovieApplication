package com.movie.domain.usecase.popularmovie

import com.movie.domain.* // ktlint-disable no-wildcard-imports
import com.movie.domain.extension.Result
import com.movie.domain.repository.MockMovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
class PopularMovieUseCaseTest {
    private lateinit var popularMoviesUseCase: PopularMovieUseCaseImpl
    private lateinit var movieRepository: MockMovieRepository

    @Before
    fun setUp() {
        movieRepository = MockMovieRepository()
        popularMoviesUseCase = PopularMovieUseCaseImpl(movieRepository)
    }

    @Test
    fun getPopularMoviesFirstItemTest() = runBlocking {
        popularMoviesUseCase().collect {
            when (it) {
                is Result.Success -> {
                    Assert.assertEquals(TROLLS_BAND_TOGETHER, it.data.first().originalTitle)
                    Assert.assertTrue(TROLLS_VOTE_AVERAGE == it.data.first().voteAverage)
                }
                else -> {}
            }
        }
    }

    @Test
    fun getPopularMoviesLastItemTest() = runBlocking {
        popularMoviesUseCase().collect {
            when (it) {
                is Result.Success -> {
                    Assert.assertEquals(FREELANCE_TITLE, it.data.last().originalTitle)
                    Assert.assertEquals(FREELANCE_RELEASE_DATE, it.data.last().releaseDate)
                    Assert.assertTrue(FREELANCE_VOTE_AVERAGE == it.data.last().voteAverage)
                }
                else -> {}
            }
        }
    }
}
