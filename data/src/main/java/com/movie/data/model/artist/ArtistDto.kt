package com.movie.data.model.artist

import com.google.gson.annotations.SerializedName
import com.movie.data.mapper.Dto
import com.movie.data.util.notNull
import com.movie.domain.entity.artist.Artist
import com.movie.domain.entity.artist.Cast
import com.movie.domain.entity.artist.Crew

data class ArtistDto(
    @SerializedName("cast")
    val cast: List<CastDto>,
    @SerializedName("crew")
    val crew: List<CrewDto>,
    @SerializedName("id")
    val id: Int,
) : Dto {
    override fun asDomain() =
        Artist(
            cast = cast.map { it }.map { castDto ->
                Cast(
                    adult = castDto.adult,
                    castId = castDto.castId,
                    character = castDto.character,
                    creditId = castDto.creditId,
                    gender = castDto.gender,
                    id = castDto.id,
                    knownForDepartment = castDto.knownForDepartment,
                    name = castDto.name,
                    order = castDto.order,
                    originalName = castDto.originalName,
                    popularity = castDto.popularity,
                    profilePath = castDto.profilePath.notNull(),
                )
            },
            crew = crew.map { it }
                .map { crewDto ->
                    Crew(
                        adult = crewDto.adult,
                        creditId = crewDto.creditId,
                        department = crewDto.department,
                        gender = crewDto.gender,
                        id = crewDto.id,
                        job = crewDto.job,
                        knownForDepartment = crewDto.knownForDepartment,
                        name = crewDto.name,
                        originalName = crewDto.originalName,
                        popularity = crewDto.popularity,
                        profilePath = crewDto.profilePath.notNull(),
                    )
                },
            id = id,
        )
}
