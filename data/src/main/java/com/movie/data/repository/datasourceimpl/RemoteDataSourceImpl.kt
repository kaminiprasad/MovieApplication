package com.movie.data.repository.datasourceimpl

import com.movie.data.api.ApiService
import com.movie.data.mapper.mapperimpl.MovieDetailMapperImpl
import com.movie.data.mapper.mapperimpl.MovieListMapperImpl
import com.movie.data.repository.datasource.RemoteDataSource
import com.movie.data.util.Constants
import com.movie.domain.entity.movie.Movie
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val listMapper: MovieListMapperImpl,
    private val movieDetailMapper: MovieDetailMapperImpl,
) : RemoteDataSource {

    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return try {
            val response = apiService.getPopularMovies()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(listMapper.map(body.results))
            } else {
                Result.Error(Constants.EXCEPTION_UNKNOWN_ERROR)
            }
        } catch (e: Throwable) {
            Result.Error(e.message ?: Constants.EXCEPTION_UNKNOWN_ERROR)
        }
    }

    override suspend fun getMovieById(id: Int): Result<MovieDetail> {
        return try {
            val response = apiService.getMovieById(id)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(movieDetailMapper.map(body))
            } else {
                Result.Error(Constants.EXCEPTION_UNKNOWN_ERROR)
            }
        } catch (e: Throwable) {
            Result.Error(e.message ?: Constants.EXCEPTION_UNKNOWN_ERROR)
        }
    }
}
