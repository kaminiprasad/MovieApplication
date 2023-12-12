package com.movie.domain.usecase.popularmovie

import com.movie.domain.entity.Movie
import com.movie.domain.extension.Result
import com.movie.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMovieUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetPopularMovieUseCase {
    override suspend fun invoke(): Flow<Result<List<Movie>>> {
        return repository.getPopularMovies()
    }
}