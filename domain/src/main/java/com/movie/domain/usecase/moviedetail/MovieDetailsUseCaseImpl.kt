package com.movie.domain.usecase.moviedetail

import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result
import com.movie.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDetailsUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : MovieDetailsUseCase {
    override suspend fun invoke(id: Int): Flow<Result<MovieDetail>> {
        return repository.getMovieById(id)
    }
}
