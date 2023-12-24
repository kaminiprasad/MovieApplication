package com.movie.app.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.app.presentation.ui.compose.MovieDetailState
import com.movie.app.presentation.ui.util.Constants.MOVIE_ID
import com.movie.app.presentation.ui.util.CoroutineContextProvider
import com.movie.domain.entity.artist.Artist
import com.movie.domain.extension.Result
import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetails: MovieDetailsUseCase,
    private val movieArtist: MovieArtistUseCase,
    private val contextProvider: CoroutineContextProvider = CoroutineContextProvider(),
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _movieState: MutableStateFlow<MovieDetailState> =
        MutableStateFlow(MovieDetailState())
    val movieState: StateFlow<MovieDetailState> = _movieState

    private val _artistState: MutableStateFlow<Artist> =
        MutableStateFlow(Artist(cast = emptyList(), crew = emptyList(), id = -1))
    val artistState: StateFlow<Artist> = _artistState

    private val _loadingState = MutableStateFlow(true)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _errorState = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState

    init {
        savedStateHandle.get<String>(MOVIE_ID)?.let {
            getMovieById(it.toInt())
            movieCredit(it.toInt())
        }
    }

    internal fun getMovieById(id: Int) = viewModelScope.launch(contextProvider.IO) {
        movieDetails(id = id).collectLatest {
            when (it) {
                is Result.Loading -> {
                    _loadingState.value = true
                }
                is Result.Success -> {
                    _loadingState.value = false
                    _movieState.value = MovieDetailState(
                        movie = it.data,
                        isLoading = false,
                        error = "",
                    )
                }
                is Result.Error -> {
                    _loadingState.value = true
                    _errorState.value = it.error
                    _movieState.value = MovieDetailState(error = it.error)
                }
                else -> {}
            }
        }
    }

    internal fun movieCredit(movieId: Int) {
        viewModelScope.launch {
            movieArtist(movieId).collectLatest {
                when (it) {
                    is Result.Loading -> {
                        _loadingState.value = true
                    }
                    is Result.Success -> {
                        _loadingState.value = false
                        _artistState.value = it.data
                    }
                    is Result.Error -> {
                        _loadingState.value = true
                        _errorState.value = it.error
                        _artistState.value = Artist(cast = emptyList(), crew = emptyList(), id = -1)
                    }
                    else -> {}
                }
            }
        }
    }
}
