package com.movie.domain.usecase.moviedetail

import com.movie.domain.entity.MovieDetail
import com.movie.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface MovieDetailsUseCase {
    suspend operator fun invoke(id: Int): Flow<Result<MovieDetail>>
}