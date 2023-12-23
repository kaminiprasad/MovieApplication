package com.movie.data.repository

import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override suspend fun getPopularMovies() =
        remoteDataSource.getPopularMovies()

    override suspend fun getMovieById(id: Int) =
        remoteDataSource.getMovieById(id)

    override suspend fun getMovieCredit(movieId: Int) =
        remoteDataSource.getMovieCredit(movieId)
}
