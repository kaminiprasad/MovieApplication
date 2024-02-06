package com.movie.presentation.ui.mapper

import com.movie.data.mapper.Mapper
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.presentation.ui.model.MovieDetailToPresentationModel
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
