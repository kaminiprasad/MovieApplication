package com.movie.presentation.ui.model

sealed class MovieDetailUIState
data class MovieDetailLoaded(val movie: MovieDetailToPresentationModel) : MovieDetailUIState()

data class MovieDetailFailure(val error: String) : MovieDetailUIState()

object MovieDetailLoading : MovieDetailUIState()
