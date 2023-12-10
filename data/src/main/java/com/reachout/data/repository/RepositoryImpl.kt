package com.reachout.data.repository

import com.reachout.data.mapper.repoFlow
import com.reachout.data.repository.datasource.RemoteDataSource
import com.reachout.data.util.notNull
import com.reachout.domain.entity.Movie
import com.reachout.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override suspend fun getPopularMovies() = repoFlow {

        remoteDataSource.getPopularMovies().results.map {
            it
        }.map { movieDto ->
            Movie(
                id = movieDto.id,
                title = movieDto.title,
                originalTitle = movieDto.originalTitle,
                backdropPath = movieDto.backdropPath,
                posterUrl = movieDto.posterPath,
                voteAverage = movieDto.voteAverage,
                releaseDate = movieDto.releaseDate.notNull()
            )
        }
    }.flowOn(dispatcher)

    override suspend fun getMovieById(id: Int) = repoFlow {
        remoteDataSource.getMovieById(id).asDomain()
    }.flowOn(dispatcher)

    override suspend fun getMovieCredit(movieId: Int) = repoFlow {
        remoteDataSource.getMovieCredit(movieId).asDomain()
    }.flowOn(dispatcher)
}