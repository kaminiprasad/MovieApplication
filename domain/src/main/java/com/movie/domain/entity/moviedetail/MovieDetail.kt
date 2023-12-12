package com.movie.domain.entity.moviedetail

import com.movie.domain.util.Domain

data class MovieDetail(
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val id: Int,
    val runtime: Int,
    val voteCount: Int,
) : Domain
