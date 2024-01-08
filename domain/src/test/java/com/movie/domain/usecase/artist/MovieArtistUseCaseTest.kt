package com.movie.domain.usecase.artist

import com.movie.domain.* // ktlint-disable no-wildcard-imports
import com.movie.domain.extension.Result
import com.movie.domain.repository.MockMovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieArtistUseCaseTest {
    private lateinit var movieDetailUseCase: MovieArtistUseCaseImpl
    private lateinit var movieRepository: MockMovieRepository

    @Before
    fun setUp() {
        movieRepository = MockMovieRepository()
        movieDetailUseCase = MovieArtistUseCaseImpl(movieRepository)
    }

    @Test
    fun getMovieCreditTest() = runBlocking {
        movieDetailUseCase(ARTIST_ID).collect {
            movieDetailUseCase(ARTIST_ID).collect {
                when (it) {
                    is Result.Success -> {
                        Assert.assertEquals(MIKE_KELSON, it.data.cast.first().name)
                        Assert.assertTrue(MIKE_KELSON_POPULARITY == it.data.cast.first().popularity)
                        Assert.assertEquals(CASTING, it.data.crew.last().job)
                        Assert.assertEquals(
                            REBECCA_CREDIT_ID,
                            it.data.crew.last().creditId,
                        )
                    }
                    else -> {}
                }
            }
        }
    }
}
