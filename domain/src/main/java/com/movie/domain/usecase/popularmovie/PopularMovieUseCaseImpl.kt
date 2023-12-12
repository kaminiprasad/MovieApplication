package com.movie.domain.usecase.popularmovie

import com.movie.domain.entity.movie.Movie
import com.movie.domain.extension.Result
import com.movie.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMovieUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : PopularMovieUseCase {
    override suspend fun invoke(): Flow<Result<List<Movie>>> {
        return repository.getPopularMovies()
    }
}
