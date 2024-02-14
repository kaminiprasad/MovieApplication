package com.movie.data.api

import com.movie.data.model.moviedetail.MovieDetailDto
import com.movie.data.model.popularmovie.PopularMoviesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<PopularMoviesDto>

    @GET("movie/{id}")
    suspend fun getMovieById(@Path("id") id: Int): Response<MovieDetailDto>
}
