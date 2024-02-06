package com.movie.presentation.ui.model

data class MovieDetailToPresentationModel(
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
)
