package com.movie.data.mapper.mapperimpl

import com.movie.data.MOVIE_TITLE
import com.movie.data.getMovieDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
@ExperimentalCoroutinesApi
class MovieListMapperImplTest {
    private lateinit var mapper: MovieListMapperImpl

    @Before
    fun setUp() {
        mapper = MovieListMapperImpl()
    }

    @Test
    fun `GIVEN a movie list WHEN the dtos of list of movies are requested THEN the list of movie's detail mapping are returned`() = runTest {
        val movieList = mapper.map(data = listOf(getMovieDto()))
        Assert.assertEquals(1, movieList.size)
        Assert.assertEquals(MOVIE_TITLE, movieList.first().originalTitle)
    }
}
