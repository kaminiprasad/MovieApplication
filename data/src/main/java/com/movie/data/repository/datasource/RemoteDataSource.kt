package com.movie.data.repository.datasource

import com.movie.domain.entity.movie.Movie
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result

interface RemoteDataSource {
    suspend fun getPopularMovies(): Result<List<Movie>>
    suspend fun getMovieById(id: Int): Result<MovieDetail>
}
