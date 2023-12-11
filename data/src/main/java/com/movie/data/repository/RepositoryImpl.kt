package com.movie.data.repository

import com.movie.data.mapper.repoFlow
import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.data.util.notNull
import com.movie.domain.entity.Movie
import com.movie.domain.repository.Repository
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
        println("CleanArch --- Repo [18] ${dispatcher.key}")
        remoteDataSource.getMovieById(id).asDomain()
    }.flowOn(dispatcher)

    override suspend fun getMovieCredit(movieId: Int) = repoFlow {
        remoteDataSource.getMovieCredit(movieId).asDomain()
    }.flowOn(dispatcher)
}