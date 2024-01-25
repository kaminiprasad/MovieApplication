package com.movie.app.presentation.ui.mapper

import com.movie.app.utils.MIKE_KELSON
import com.movie.app.utils.SCOTT_CHAMBERS_PROFILE_PATH
import com.movie.app.utils.getMovieCast
import com.movie.app.utils.getMovieCrew
import com.movie.domain.entity.artist.Artist
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
class DomainArtistToPresentationMapperImplTest {
    private lateinit var mapper: DomainArtistToPresentationMapperImpl

    @Before
    fun setUp() {
        mapper = DomainArtistToPresentationMapperImpl()
    }

    @Test
    fun `GIVEN an artist WHEN the dtos of domain artist's crew and cast are requested THEN the artist's mapping details for the presentation are returned`() =
        runTest {
            val artist =
                mapper.map(data = Artist(cast = getMovieCast(), crew = getMovieCrew(), -1))

            Assert.assertEquals(MIKE_KELSON, artist.cast.first().name)
            Assert.assertEquals(SCOTT_CHAMBERS_PROFILE_PATH, artist.crew.first().profilePath)
            Assert.assertEquals(2, artist.cast.size)
            Assert.assertEquals(2, artist.crew.size)
        }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
