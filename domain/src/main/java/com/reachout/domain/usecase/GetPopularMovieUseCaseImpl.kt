package com.reachout.domain.usecase

import com.reachout.domain.entity.Movie
import com.reachout.domain.extension.Result
import com.reachout.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMovieUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetPopularMovieUseCase {
    override suspend fun invoke(): Flow<Result<List<Movie>>> {
        return repository.getPopularMovies()
    }
}