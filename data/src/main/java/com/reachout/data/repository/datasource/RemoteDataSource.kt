package com.reachout.data.repository.datasource

import com.reachout.data.model.MovieDetailDto
import com.reachout.data.model.PopularMoviesDto
import com.reachout.data.model.artist.ArtistDto

interface RemoteDataSource {
    suspend fun getPopularMovies(): PopularMoviesDto
    suspend fun getMovieById(id : Int): MovieDetailDto
    suspend fun getMovieCredit(movieId : Int): ArtistDto
}