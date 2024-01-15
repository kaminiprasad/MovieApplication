package com.movie.data.repository

import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override suspend fun getPopularMovies() =
        remoteDataSource.getPopularMovies().flowOn(dispatcher)

    override suspend fun getMovieById(id: Int) =
        remoteDataSource.getMovieById(id).flowOn(dispatcher)

    override suspend fun getMovieCredit(movieId: Int) =
        remoteDataSource.getMovieCredit(movieId).flowOn(dispatcher)
}
