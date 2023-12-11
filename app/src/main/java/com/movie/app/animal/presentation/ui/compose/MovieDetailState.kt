package com.movie.app.animal.presentation.ui.compose

import com.movie.domain.entity.MovieDetail

data class MovieDetailState(
    val movie: MovieDetail? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
