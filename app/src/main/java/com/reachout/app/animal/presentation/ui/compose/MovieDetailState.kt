package com.reachout.app.animal.presentation.ui.compose

import com.reachout.domain.entity.MovieDetail

data class MovieDetailState(
    val movie: MovieDetail? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
