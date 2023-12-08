package com.reachout.domain.repository

import com.reachout.domain.entity.Animal
import kotlinx.coroutines.flow.Flow
import com.reachout.domain.extension.Result

interface Repository {
    suspend fun getItemList(number: Int): Flow<Result<List<Animal>>>
}