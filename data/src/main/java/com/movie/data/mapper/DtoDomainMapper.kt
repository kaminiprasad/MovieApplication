package com.movie.data.mapper

import com.movie.data.util.Constants.EXCEPTION_DESCRIPTION
import com.movie.data.util.Constants.EXCEPTION_UNKNOWN_ERROR
import com.movie.domain.extension.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

inline fun <T> repoFlow(
    crossinline block: suspend () -> T
): Flow<Result<T>> = flow {
    emit(emitSuccess(block()))
}.catch {
    println(EXCEPTION_DESCRIPTION.plus({ it.stackTrace }))
    emit(emitError(it.message ?: EXCEPTION_UNKNOWN_ERROR))
}
fun <T> emitSuccess(repoResult: T): Result<T> {
    return Result.Success(repoResult)
}
fun <T> emitError(errorMessage: String): Result<T> {
    return Result.Error(errorMessage)
}
