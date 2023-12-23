package com.movie.data.mapper.mapperimpl

import com.movie.data.mapper.Mapper
import com.movie.data.model.moviedetail.MovieDetailDto
import com.movie.domain.entity.moviedetail.MovieDetail
import javax.inject.Inject

class MovieDetailMapperImpl @Inject constructor() : Mapper<MovieDetailDto, MovieDetail> {
    override fun map(data: MovieDetailDto) = with(data) {
        MovieDetail(
            id = id,
            backdropPath = backdropPath,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            posterPath = posterPath,
            releaseDate = releaseDate,
            runtime = runtime,
            status = status,
            tagline = tagline,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount,
        )
    }
}
