package com.movie.data.repository.datasourceimpl

import com.movie.data.api.ApiService
import com.movie.data.mapper.mapperimpl.ArtistMapperImpl
import com.movie.data.mapper.mapperimpl.MovieDetailMapperImpl
import com.movie.data.mapper.mapperimpl.MovieListMapperImpl
import com.movie.data.mapper.repoFlow
import com.movie.data.repository.datasource.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val listMapper: MovieListMapperImpl,
    private val movieDetailMapper: MovieDetailMapperImpl,
    private val artistMapper: ArtistMapperImpl,
) : RemoteDataSource {

    override suspend fun getPopularMovies() = repoFlow {
        listMapper.map(apiService.getPopularMovies().results)
    }

    override suspend fun getMovieById(id: Int) = repoFlow {
        movieDetailMapper.map(apiService.getMovieById(id))
    }

    override suspend fun getMovieCredit(movieId: Int) = repoFlow {
        artistMapper.map(apiService.getMovieCredit(movieId))
    }
}
