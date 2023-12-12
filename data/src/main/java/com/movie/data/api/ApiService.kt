package com.movie.data.api

import com.movie.data.model.moviedetail.MovieDetailDto
import com.movie.data.model.popularmovie.PopularMoviesDto
import com.movie.data.model.artist.ArtistDto
import retrofit2.http.*


interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesDto

    @GET("movie/{id}")
    suspend fun getMovieById(@Path("id") id: Int): MovieDetailDto

    @GET("movie/{movieId}/credits")
    suspend fun getMovieCredit(@Path("movieId") movieId: Int): ArtistDto
}