package com.reachout.data.mapper

import com.reachout.domain.Domain
import com.reachout.domain.extension.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform

interface Dto {
    fun asDomain(): Domain
}

inline fun <T> repoFlow(
    crossinline block: suspend () -> T,
): Flow<Result<T>> = flow {
    try {
        val repoResult = block()
        emit(Result.Success(repoResult))
    } catch (e: Exception) {
        println("Interceptor [19]: ${e.message}")
        emit(Result.Error(e.message ?: "Unknown error"))
    }
}

fun Flow<Dto>.toDomain(): Flow<Domain> = transform { value ->
    return@transform emit(value.asDomain())
}
