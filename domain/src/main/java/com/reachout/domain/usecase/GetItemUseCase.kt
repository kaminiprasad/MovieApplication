package com.reachout.domain.usecase

import com.reachout.domain.entity.Animal
import com.reachout.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface GetItemUseCase {
    suspend operator fun invoke(number: Int) : Flow<Result<List<Animal>>>
}