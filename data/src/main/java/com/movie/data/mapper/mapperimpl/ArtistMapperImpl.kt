package com.movie.data.mapper.mapperimpl

import com.movie.data.mapper.Mapper
import com.movie.data.model.artist.ArtistDto
import com.movie.data.util.notNull
import com.movie.domain.entity.artist.Artist
import com.movie.domain.entity.artist.Cast
import com.movie.domain.entity.artist.Crew
import javax.inject.Inject

class ArtistMapperImpl @Inject constructor() : Mapper<ArtistDto, Artist> {
    override fun map(data: ArtistDto) = with(data) {
        Artist(
            cast = cast.map { it }.map { castDto ->
                with(castDto) {
                    Cast(
                        adult = adult,
                        castId = castId,
                        character = character,
                        creditId = creditId,
                        gender = gender,
                        id = id,
                        knownForDepartment = knownForDepartment,
                        name = name,
                        order = order,
                        originalName = originalName,
                        popularity = popularity,
                        profilePath = profilePath.notNull(),
                    )
                }
            },
            crew = crew.map { it }
                .map { crewDto ->
                    with(crewDto) {
                        Crew(
                            adult = adult,
                            creditId = creditId,
                            department = department,
                            gender = gender,
                            id = id,
                            job = job,
                            knownForDepartment = knownForDepartment,
                            name = name,
                            originalName = originalName,
                            popularity = popularity,
                            profilePath = profilePath.notNull(),
                        )
                    }
                },
            id = id,
        )
    }
}
