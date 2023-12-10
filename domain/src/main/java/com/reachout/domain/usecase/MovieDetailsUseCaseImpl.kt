package com.reachout.domain.usecase

import com.reachout.domain.entity.MovieDetail
import com.reachout.domain.extension.Result
import com.reachout.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDetailsUseCaseImpl @Inject constructor(
    private val repository: Repository
) : MovieDetailsUseCase {
    override suspend fun invoke(id: Int): Flow<Result<MovieDetail>> {
        return repository.getMovieById(id)
    }
}