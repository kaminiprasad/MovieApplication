package com.movie.data.repository.datasource

import com.movie.data.model.MovieDetailDto
import com.movie.data.model.PopularMoviesDto
import com.movie.data.model.artist.ArtistDto

interface RemoteDataSource {
    suspend fun getPopularMovies(): PopularMoviesDto
    suspend fun getMovieById(id : Int): MovieDetailDto
    suspend fun getMovieCredit(movieId : Int): ArtistDto
}