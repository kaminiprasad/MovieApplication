package com.movie.domain.repository

import com.movie.domain.entity.artist.Artist
import com.movie.domain.entity.movie.Movie
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getPopularMovies(): Flow<Result<List<Movie>>>
    suspend fun getMovieById(id: Int): Flow<Result<MovieDetail>>
    suspend fun getMovieCredit(movieId: Int): Flow<Result<Artist>>
}
