package com.movie.data.mapper.mapperimpl

import com.movie.data.mapper.ListMapper
import com.movie.data.model.moviedetail.MovieDto
import com.movie.data.util.notEmpty
import com.movie.domain.entity.movie.Movie
import javax.inject.Inject

class MovieListMapperImpl @Inject constructor() : ListMapper<MovieDto, Movie> {
    override fun map(data: List<MovieDto>): List<Movie> {
        return data.map {
            it
        }.map { movieDto ->
            with(movieDto) {
                Movie(
                    id = id,
                    title = title,
                    originalTitle = originalTitle,
                    backdropPath = backdropPath,
                    posterUrl = posterPath,
                    voteAverage = voteAverage,
                    releaseDate = releaseDate.notEmpty(),
                )
            }
        }
    }
}
