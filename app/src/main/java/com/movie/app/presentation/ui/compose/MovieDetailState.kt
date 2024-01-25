package com.movie.app.presentation.ui.compose

import com.movie.app.presentation.ui.model.MovieDetailToPresentationModel

data class MovieDetailState(
    val movie: MovieDetailToPresentationModel? = null,
    val isLoading: Boolean = false,
    val error: String = "",
)
