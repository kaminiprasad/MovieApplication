package com.movie.domain.usecase

import com.movie.domain.entity.Movie
import com.movie.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface GetPopularMovieUseCase {
    suspend operator fun invoke() : Flow<Result<List<Movie>>>
}