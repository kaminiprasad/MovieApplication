package com.movie.domain.usecase.moviedetail

import com.movie.domain.ARTIST_ID
import com.movie.domain.MOVIE_DETAIL_TITLE
import com.movie.domain.MOVIE_DETAIL_VOTE_COUNT
import com.movie.domain.repository.MockMovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieDetailsUseCaseTest {
    private var movieDetailUseCase: MovieDetailsUseCase = mockk()
    private lateinit var movieRepository: MockMovieRepository

    @Before
    fun setUp() {
        movieRepository = MockMovieRepository()
    }

    @Test
    fun `GIVEN a movie WHEN the movie detail's of particular movie is requested THEN the movie's details will be returned`() =
        runTest {
            // Given
            val expectedList = movieRepository.getMovieById(ARTIST_ID)
            coEvery { movieDetailUseCase(ARTIST_ID) } returns expectedList

            // when
            val actualData = movieDetailUseCase(ARTIST_ID)

            // Then
            Assert.assertEquals(actualData, actualData)
            Assert.assertEquals(MOVIE_DETAIL_TITLE, expectedList.data.title)
            Assert.assertTrue(MOVIE_DETAIL_VOTE_COUNT == expectedList.data.voteCount)
        }
}
