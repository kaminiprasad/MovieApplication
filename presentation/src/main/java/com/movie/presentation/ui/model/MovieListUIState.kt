package com.movie.presentation.ui.model

sealed class MovieListUIState
data class MoviesLoaded(val data: List<DomainMovieToPresentationModel>) : MovieListUIState()
data class MovieFailure(val error: String) : MovieListUIState()
object MoviesLoading : MovieListUIState()