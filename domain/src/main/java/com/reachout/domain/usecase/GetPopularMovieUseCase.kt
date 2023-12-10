package com.reachout.domain.usecase

import com.reachout.domain.entity.Movie
import com.reachout.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface GetPopularMovieUseCase {
    suspend operator fun invoke() : Flow<Result<List<Movie>>>
}