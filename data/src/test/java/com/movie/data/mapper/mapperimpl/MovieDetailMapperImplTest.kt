package com.movie.data.mapper.mapperimpl

import com.movie.data.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.ExperimentalCoroutinesApi // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
@ExperimentalCoroutinesApi
class MovieDetailMapperImplTest {
    private lateinit var mapper: MovieDetailMapperImpl

    @Before
    fun setUp() {
        mapper = MovieDetailMapperImpl()
    }

    @Test
    fun `GIVEN a movie WHEN the dto of movie detail is requested THEN the movie's detail mapping is returned`() = runTest {
        val movieDetail = mapper.map(data = getMovieDetailsDto())
        Assert.assertEquals(MOVIE_DETAIL_BACKDROP_PATH, movieDetail.backdropPath)
        Assert.assertEquals(MOVIE_DETAIL_TITLE, movieDetail.originalTitle)
    }
}
