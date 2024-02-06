package com.movie.presentation.ui.mapper

import com.movie.data.mapper.Mapper
import com.movie.data.util.notNull
import com.movie.domain.entity.artist.Artist
import com.movie.presentation.ui.model.DomainArtistToPresentationModel
import com.movie.presentation.ui.model.DomainCastToPresentationModel
import com.movie.presentation.ui.model.DomainToCrewPresentationModel
import javax.inject.Inject

class DomainArtistToPresentationMapperImpl @Inject constructor() :
    Mapper<Artist, DomainArtistToPresentationModel> {
    override fun map(data: Artist) = with(data) {
        DomainArtistToPresentationModel(
            cast = cast.map { it }.map { castDto ->
                with(castDto) {
                    DomainCastToPresentationModel(
                        name = name,
                        profilePath = profilePath.notNull(),
                    )
                }
            },
            crew = crew.map { it }
                .map { crewDto ->
                    with(crewDto) {
                        DomainToCrewPresentationModel(
                            name = name,
                            profilePath = profilePath.notNull(),
                        )
                    }
                },
            id = id,
        )
    }
}
