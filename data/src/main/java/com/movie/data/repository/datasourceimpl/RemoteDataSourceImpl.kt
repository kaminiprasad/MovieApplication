package com.movie.data.repository.datasourceimpl

import com.movie.data.api.ApiService
import com.movie.data.model.MovieDetailDto
import com.movie.data.model.PopularMoviesDto
import com.movie.data.model.artist.ArtistDto
import com.movie.data.repository.datasource.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getPopularMovies(): PopularMoviesDto {
        return apiService.getPopularMovies()
    }

    override suspend fun getMovieById(id: Int): MovieDetailDto {
        println("CleanArch --- DataSource [15]")
        return apiService.getMovieById(id)
    }

    override suspend fun getMovieCredit(movieId: Int): ArtistDto {
        return apiService.getMovieCredit(movieId)
    }
}