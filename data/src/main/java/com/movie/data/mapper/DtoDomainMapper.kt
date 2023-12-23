package com.movie.data.mapper

import android.util.Log
import com.movie.domain.extension.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

inline fun <T> repoFlow(
    crossinline block: suspend () -> T,
): Flow<Result<T>> = flow {
    try {
        val repoResult = block()
        emit(Result.Success(repoResult))
    } catch (e: Exception) {
        Log.e("Exception", "Exception while fetching data : ${e.stackTrace}")
        emit(Result.Error(e.message ?: "Unknown error"))
    }
}
