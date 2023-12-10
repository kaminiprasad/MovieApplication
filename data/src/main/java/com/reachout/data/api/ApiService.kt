package com.reachout.data.api

import com.reachout.data.model.MovieDetailDto
import com.reachout.data.model.PopularMoviesDto
import com.reachout.data.model.artist.ArtistDto
import retrofit2.http.*


interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesDto

    @GET("movie/{id}")
    suspend fun getMovieById(@Path("id") id: Int): MovieDetailDto

    @GET("movie/{movieId}/credits")
    suspend fun getMovieCredit(@Path("movieId") movieId: Int): ArtistDto
}