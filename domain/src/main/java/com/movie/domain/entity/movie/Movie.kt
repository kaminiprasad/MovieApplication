package com.movie.domain.entity.movie

data class Movie(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val backdropPath: String,
    val posterUrl: String,
    val voteAverage: Double,
    val releaseDate: String,
)
