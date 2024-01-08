package com.movie.data.mapper.mapperimpl

import com.movie.data.EXECUTIVE_PRODUCER
import com.movie.data.MIKE_KELSON_CAST_ID
import com.movie.data.getMovieCastDto
import com.movie.data.getMovieCrewDto
import com.movie.data.model.artist.ArtistDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ArtistMapperImplTest {
    private lateinit var mapper: ArtistMapperImpl

    @Before
    fun setUp() {
        mapper = ArtistMapperImpl()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun artistDtoTest() = runTest {
        val artist =
            mapper.map(data = ArtistDto(cast = getMovieCastDto(), crew = getMovieCrewDto(), -1))

        assertEquals(MIKE_KELSON_CAST_ID, artist.cast.first().castId)
        assertEquals(EXECUTIVE_PRODUCER, artist.crew.first().job)
        assertEquals(2, artist.cast.size)
        assertEquals(2, artist.crew.size)
    }
}
