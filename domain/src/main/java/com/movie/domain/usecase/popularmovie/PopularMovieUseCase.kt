package com.movie.domain.usecase.popularmovie

import com.movie.domain.entity.movie.Movie
import com.movie.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface PopularMovieUseCase {
    suspend operator fun invoke(): Flow<Result<List<Movie>>>
}
