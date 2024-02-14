package com.movie.data.repository

import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override suspend fun getPopularMovies() =
        remoteDataSource.getPopularMovies()

    override suspend fun getMovieById(id: Int) =
        remoteDataSource.getMovieById(id)
}
