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
@ExperimentalCoroutinesApi
class ArtistMapperImplTest {
    private lateinit var mapper: ArtistMapperImpl

    @Before
    fun setUp() {
        mapper = ArtistMapperImpl()
    }

    @Test
    fun `GIVEN an artist WHEN the dtos of artist's crew and cast are requested THEN the artist's mapping details are returned`() = runTest {
        val artist =
            mapper.map(data = ArtistDto(cast = getMovieCastDto(), crew = getMovieCrewDto(), -1))

        assertEquals(MIKE_KELSON_CAST_ID, artist.cast.first().castId)
        assertEquals(EXECUTIVE_PRODUCER, artist.crew.first().job)
        assertEquals(2, artist.cast.size)
        assertEquals(2, artist.crew.size)
    }
}
