package com.movie.domain.usecase.artist

import com.movie.domain.ARTIST_ID
import com.movie.domain.CASTING
import com.movie.domain.MIKE_KELSON
import com.movie.domain.MIKE_KELSON_POPULARITY
import com.movie.domain.REBECCA_CREDIT_ID
import com.movie.domain.repository.MockMovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieArtistUseCaseTest {
    private var movieDetailUseCase: MovieArtistUseCase = mockk()
    private lateinit var movieRepository: MockMovieRepository

    @Before
    fun setUp() {
        movieRepository = MockMovieRepository()
    }

    @Test
    fun `GIVEN a movie artist WHEN the movie detail's of an artis is requested THEN the artist's detail will be returned`() =
        runTest {
            // Given
            val expectedList = movieRepository.getMovieCredit(ARTIST_ID)
            coEvery { movieDetailUseCase(ARTIST_ID) } returns expectedList

            // when
            val artistData = movieDetailUseCase(ARTIST_ID)

            // Then
            Assert.assertEquals(artistData, expectedList)
            Assert.assertEquals(MIKE_KELSON, expectedList.data.cast.first().name)
            Assert.assertTrue(MIKE_KELSON_POPULARITY == expectedList.data.cast.first().popularity)
            Assert.assertEquals(CASTING, expectedList.data.crew.last().job)
            Assert.assertEquals(
                REBECCA_CREDIT_ID,
                expectedList.data.crew.last().creditId,
            )
        }
}
