package com.movie.domain.usecase.popularmovie

import com.movie.domain.entity.movie.Movie
import com.movie.domain.extension.Result

interface PopularMovieUseCase {
    suspend operator fun invoke(): Result<List<Movie>>
}
