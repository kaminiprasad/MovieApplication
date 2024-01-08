package com.movie.domain.usecase.moviedetail

import com.movie.domain.ARTIST_ID
import com.movie.domain.MOVIE_DETAIL_TITLE
import com.movie.domain.MOVIE_DETAIL_VOTE_COUNT
import com.movie.domain.extension.Result
import com.movie.domain.repository.MockMovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieDetailsUseCaseTest {
    private lateinit var movieDetailUseCase: MovieDetailsUseCaseImpl
    private lateinit var movieRepository: MockMovieRepository

    @Before
    fun setUp() {
        movieRepository = MockMovieRepository()
        movieDetailUseCase = MovieDetailsUseCaseImpl(movieRepository)
    }

    @Test
    fun getMovieDetailTest() = runBlocking {
        movieDetailUseCase(ARTIST_ID).collect {
            when (it) {
                is Result.Success -> {
                    Assert.assertEquals(MOVIE_DETAIL_TITLE, it.data.title)
                    Assert.assertTrue(MOVIE_DETAIL_VOTE_COUNT == it.data.voteCount)
                }
                else -> {}
            }
        }
    }
}
