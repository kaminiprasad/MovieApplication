package com.movie.domain.usecase.moviedetail

import com.movie.domain.extension.Result
import com.movie.domain.repository.FakeMovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieDetailsUseCaseTest {
    private lateinit var movieDetailUseCase: MovieDetailsUseCaseImpl
    private lateinit var movieRepository: FakeMovieRepository

    @Before
    fun setUp() {
        movieRepository = FakeMovieRepository()
        movieDetailUseCase = MovieDetailsUseCaseImpl(movieRepository)
    }

    @Test
    fun getMovieDetailTest() = runBlocking {
        movieDetailUseCase(951546).collect {
            when (it) {
                is Result.Success -> {
                    Assert.assertEquals("Wonka", it.data.title)
                    Assert.assertTrue(88 == it.data.voteCount)
                }
                else -> {}
            }
        }
    }
}
