package com.movie.domain.usecase.popularmovie

import com.movie.domain.extension.Result
import com.movie.domain.repository.FakeMovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class PopularMovieUseCaseTest {
    private lateinit var popularMoviesUseCase: PopularMovieUseCaseImpl
    private lateinit var movieRepository: FakeMovieRepository

    @Before
    fun setUp() {
        movieRepository = FakeMovieRepository()
        popularMoviesUseCase = PopularMovieUseCaseImpl(movieRepository)
    }

    @Test
    fun getPopularMoviesFirstItemTest() = runBlocking {
        popularMoviesUseCase().collect {
            when (it) {
                is Result.Success -> {
                    Assert.assertEquals("Trolls Band Together", it.data.first().originalTitle)
                    Assert.assertTrue(6.3 == it.data.first().voteAverage)
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
                    Assert.assertEquals("Freelance", it.data.last().originalTitle)
                    Assert.assertEquals("2023-10-12", it.data.last().releaseDate)
                    Assert.assertTrue(7.150 == it.data.last().voteAverage)
                }
                else -> {}
            }
        }
    }
}
