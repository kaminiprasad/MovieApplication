package com.movie.app.presentation.ui.mapper

import com.movie.app.presentation.ui.model.MovieDetailToPresentationModel
import com.movie.data.mapper.Mapper
import com.movie.domain.entity.moviedetail.MovieDetail
import javax.inject.Inject

class MovieDetailToPresentationMapperImpl @Inject constructor() :
    Mapper<MovieDetail, MovieDetailToPresentationModel> {
    override fun map(data: MovieDetail) = with(data) {
        MovieDetailToPresentationModel(
            backdropPath = backdropPath,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            releaseDate = releaseDate,
            title = title,
            voteAverage = voteAverage,
        )
    }
}
