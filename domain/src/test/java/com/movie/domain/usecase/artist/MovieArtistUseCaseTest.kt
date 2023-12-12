package com.movie.domain.usecase.artist

import com.movie.domain.extension.Result
import com.movie.domain.repository.FakeMovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieArtistUseCaseTest {
    private lateinit var movieDetailUseCase: MovieArtistUseCaseImpl
    private lateinit var movieRepository: FakeMovieRepository

    @Before
    fun setUp() {
        movieRepository = FakeMovieRepository()
        movieDetailUseCase = MovieArtistUseCaseImpl(movieRepository)
    }

    @Test
    fun getMovieCreditTest() = runBlocking {
        movieDetailUseCase(951546).collect {
            movieDetailUseCase(951546).collect {
                when (it) {
                    is Result.Success -> {
                        Assert.assertEquals("Mike Kelson", it.data.cast.first().name)
                        Assert.assertTrue(2.092 == it.data.cast.first().popularity)
                        Assert.assertEquals("Casting", it.data.crew.last().job)
                        Assert.assertEquals(
                            "63eb134f699fb70084e0c5e1",
                            it.data.crew.last().creditId,
                        )
                    }
                    else -> {}
                }
            }
        }
    }
}
