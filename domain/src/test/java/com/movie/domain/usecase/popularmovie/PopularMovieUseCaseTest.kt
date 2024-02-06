package com.movie.domain.usecase.popularmovie

import com.movie.domain.FREELANCE_RELEASE_DATE
import com.movie.domain.FREELANCE_TITLE
import com.movie.domain.FREELANCE_VOTE_AVERAGE
import com.movie.domain.TROLLS_BAND_TOGETHER
import com.movie.domain.TROLLS_VOTE_AVERAGE
import com.movie.domain.repository.MockMovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PopularMovieUseCaseTest {
    private var popularMoviesUseCase: PopularMovieUseCase = mockk()
    private lateinit var movieRepository: MockMovieRepository

    @Before
    fun setUp() {
        movieRepository = MockMovieRepository()
    }

    @Test
    fun `GIVEN a popular movie WHEN the movie list are requested THEN the details of the first popular movie in the movie list's data will be returned`() =
        runTest {
            //Given
            val expectedList = movieRepository.getPopularMovies()
            coEvery { popularMoviesUseCase() } returns expectedList

            //when
            val actualData = popularMoviesUseCase()

            //Then
            Assert.assertEquals(actualData, expectedList)
            Assert.assertEquals(TROLLS_BAND_TOGETHER, expectedList.data.first().originalTitle)
            Assert.assertTrue(TROLLS_VOTE_AVERAGE == expectedList.data.first().voteAverage)
        }

    @Test
    fun `GIVEN a popular movie WHEN the movie list are requested THEN the details of the last popular movie item in the list's data will be returned`() =
        runTest {
            //Given
            val expectedList = movieRepository.getPopularMovies()
            coEvery { popularMoviesUseCase() } returns expectedList

            //when
            val actualData = popularMoviesUseCase()

            //Then
            Assert.assertEquals(actualData, expectedList)
            Assert.assertEquals(FREELANCE_TITLE, expectedList.data.last().originalTitle)
            Assert.assertEquals(FREELANCE_RELEASE_DATE, expectedList.data.last().releaseDate)
            Assert.assertTrue(FREELANCE_VOTE_AVERAGE == expectedList.data.last().voteAverage)
        }
}
