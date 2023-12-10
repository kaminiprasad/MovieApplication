package com.reachout.data.mapper

import com.reachout.data.model.MovieDto
import com.reachout.data.util.notNull
import com.reachout.domain.entity.Movie

class DataMapperImpl : DataMapper<MovieDto, Movie> {
    override fun map(input: MovieDto): Movie {
        return Movie(
            input.id,
            input.title,
            input.originalTitle,
            input.backdropPath,
            input.posterPath,
            input.voteAverage,
            input.releaseDate.notNull()
        )
    }
}