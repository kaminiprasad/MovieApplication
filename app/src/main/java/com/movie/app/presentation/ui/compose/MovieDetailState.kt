package com.movie.app.presentation.ui.compose

import com.movie.domain.entity.moviedetail.MovieDetail

data class MovieDetailState(
    val movie: MovieDetail? = null,
    val isLoading: Boolean = false,
    val error: String = "",
)
