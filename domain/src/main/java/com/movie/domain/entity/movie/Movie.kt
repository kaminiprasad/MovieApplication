package com.movie.domain.entity.movie

import com.movie.domain.util.Domain

data class Movie(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val backdropPath: String,
    val posterUrl: String,
    val voteAverage: Double,
    val releaseDate: String,
) : Domain
