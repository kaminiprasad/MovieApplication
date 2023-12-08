package com.reachout.domain.usecase

import com.reachout.domain.entity.Animal
import com.reachout.domain.extension.Result
import com.reachout.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemUseCaseImpl @Inject constructor(
    private val repository: Repository
) : GetItemUseCase {
    override suspend fun invoke(number: Int): Flow<Result<List<Animal>>> =
        repository.getItemList(number)
}