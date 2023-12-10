package com.reachout.domain.usecase

import com.reachout.domain.entity.MovieDetail
import com.reachout.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface MovieDetailsUseCase {
    suspend operator fun invoke(id: Int): Flow<Result<MovieDetail>>
}