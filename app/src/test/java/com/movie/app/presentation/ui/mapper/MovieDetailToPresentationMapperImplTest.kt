package com.movie.app.presentation.ui.mapper

import com.movie.app.utils.MOVIE_DETAIL_RELEASE_DATE
import com.movie.app.utils.MOVIE_DETAIL_TITLE
import com.movie.app.utils.getMovieDetail
import io.mockk.clearAllMocks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieDetailToPresentationMapperImplTest {
    private lateinit var mapper: MovieDetailToPresentationMapperImpl

    @Before
    fun setUp() {
        mapper = MovieDetailToPresentationMapperImpl()
    }

    @Test
    fun `GIVEN a movie detail WHEN a movie with particular id is requested THEN the movie detail is returned`() =
        runTest {

            val movieDetailToPresentationModel =
                mapper.map(data = getMovieDetail())

            Assert.assertEquals(MOVIE_DETAIL_TITLE, movieDetailToPresentationModel.title)
            Assert.assertEquals(
                MOVIE_DETAIL_RELEASE_DATE,
                movieDetailToPresentationModel.releaseDate
            )
        }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
