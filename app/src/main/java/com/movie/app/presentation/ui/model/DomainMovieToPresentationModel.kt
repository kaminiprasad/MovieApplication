package com.movie.app.presentation.ui.model

data class DomainMovieToPresentationModel(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val posterUrl: String,
    val voteAverage: Double,
    val releaseDate: String,
)
