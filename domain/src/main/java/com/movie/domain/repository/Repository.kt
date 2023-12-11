package com.movie.domain.repository

import com.movie.domain.entity.Movie
import com.movie.domain.entity.MovieDetail
import com.movie.domain.entity.artist.Artist
import kotlinx.coroutines.flow.Flow
import com.movie.domain.extension.Result

interface Repository {
    suspend fun getPopularMovies(): Flow<Result<List<Movie>>>
    suspend fun getMovieById(id:Int): Flow<Result<MovieDetail>>
    suspend fun getMovieCredit(movieId:Int): Flow<Result<Artist>>

}