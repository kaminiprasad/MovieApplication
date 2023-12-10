package com.reachout.domain.repository

import com.reachout.domain.entity.Movie
import com.reachout.domain.entity.MovieDetail
import com.reachout.domain.entity.artist.Artist
import kotlinx.coroutines.flow.Flow
import com.reachout.domain.extension.Result

interface Repository {
    suspend fun getPopularMovies(): Flow<Result<List<Movie>>>
    suspend fun getMovieById(id:Int): Flow<Result<MovieDetail>>
    suspend fun getMovieCredit(movieId:Int): Flow<Result<Artist>>

}