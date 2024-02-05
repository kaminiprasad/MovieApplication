package com.movie.domain.usecase.popularmovie

import com.movie.domain.entity.movie.Movie
import com.movie.domain.extension.Result
import com.movie.domain.repository.Repository
import javax.inject.Inject

class PopularMovieUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : PopularMovieUseCase {
    override suspend fun invoke(): Result<List<Movie>> {
        return repository.getPopularMovies()
    }
}
