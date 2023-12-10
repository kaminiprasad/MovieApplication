package com.reachout.data.repository.datasourceimpl

import com.reachout.data.api.ApiService
import com.reachout.data.model.MovieDetailDto
import com.reachout.data.model.PopularMoviesDto
import com.reachout.data.model.artist.ArtistDto
import com.reachout.data.repository.datasource.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getPopularMovies(): PopularMoviesDto {
        return apiService.getPopularMovies()
    }

    override suspend fun getMovieById(id: Int): MovieDetailDto {
        return apiService.getMovieById(id)
    }

    override suspend fun getMovieCredit(movieId: Int): ArtistDto {
        return apiService.getMovieCredit(movieId)
    }
}