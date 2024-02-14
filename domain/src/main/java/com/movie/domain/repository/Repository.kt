package com.movie.domain.repository

import com.movie.domain.entity.movie.Movie
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result

interface Repository {
    suspend fun getPopularMovies(): Result<List<Movie>>
    suspend fun getMovieById(id: Int): Result<MovieDetail>
}
