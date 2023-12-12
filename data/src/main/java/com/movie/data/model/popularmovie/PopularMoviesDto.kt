package com.movie.data.model.popularmovie

import com.google.gson.annotations.SerializedName
import com.movie.data.model.moviedetail.MovieDto

data class PopularMoviesDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDto>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)