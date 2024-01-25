package com.movie.app.presentation.ui.mapper

import com.movie.app.presentation.ui.model.DomainMovieToPresentationModel
import com.movie.data.mapper.ListMapper
import com.movie.data.util.notNull
import com.movie.domain.entity.movie.Movie
import javax.inject.Inject

class DomainMovieToPresentationMapperImpl @Inject constructor() :
    ListMapper<Movie, DomainMovieToPresentationModel> {
    override fun map(data: List<Movie>): List<DomainMovieToPresentationModel> {
        return data.map {
            it
        }.map { movie ->
            with(movie) {
                DomainMovieToPresentationModel(
                    id = id,
                    title = title,
                    originalTitle = originalTitle,
                    posterUrl = posterUrl,
                    voteAverage = voteAverage,
                    releaseDate = releaseDate.notNull(),
                )
            }
        }
    }
}
