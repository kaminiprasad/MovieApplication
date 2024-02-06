package com.movie.presentation.ui.mapper

import com.movie.presentation.utils.FREELANCE_TITLE
import com.movie.presentation.utils.TROLLS_BAND_TOGETHER
import com.movie.presentation.utils.getPopularMovies
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
class DomainMovieToPresentationMapperImplTest {
    private lateinit var mapper: DomainMovieToPresentationMapperImpl

    @Before
    fun setUp() {
        mapper = DomainMovieToPresentationMapperImpl()
    }

    @Test
    fun `GIVEN list of movies as input WHEN movie items are requested THEN the movie list for the presentation is returned`() =
        runTest {
            val domainMovieToPresentationModel =
                mapper.map(data = getPopularMovies())

            Assert.assertEquals(
                FREELANCE_TITLE,
                domainMovieToPresentationModel.last().originalTitle
            )
            Assert.assertEquals(TROLLS_BAND_TOGETHER, domainMovieToPresentationModel.first().title)
            Assert.assertEquals(3, domainMovieToPresentationModel.size)
        }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
