package com.movie.data.mapper

import com.movie.data.util.Constants.EXCEPTION_UNKNOWN_ERROR
import com.movie.domain.extension.Result

suspend fun <T> repoResult(
    block: suspend () -> T
): Result<T> {
    return try {
        displaySuccess(block())
    } catch (e: Exception) {
        displayError(e.message ?: EXCEPTION_UNKNOWN_ERROR)
    }
}
fun <T> displaySuccess(repoResult: T): Result<T> {
    return Result.Success(repoResult)
}
fun <T> displayError(errorMessage: String): Result<T> {
    return Result.Error(errorMessage)
}
