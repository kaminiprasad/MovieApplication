package com.reachout.app.animal.presentation.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reachout.app.animal.presentation.ui.compose.MovieDetailState
import com.reachout.domain.entity.artist.Artist
import com.reachout.domain.extension.Result
import com.reachout.domain.usecase.MovieDetailsUseCaseImpl
import com.reachout.domain.usecase.artist.MovieArtistUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetails: MovieDetailsUseCaseImpl,
    private val movieArtist: MovieArtistUseCaseImpl,
    savedStateHandle: SavedStateHandle
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
        savedStateHandle.get<String>("movie_id")?.let {
            getMovieById(it.toInt())
            movieCredit(it.toInt())
        }
    }

    fun getMovieById(id: Int) = viewModelScope.launch {
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
                        error = ""
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

    fun movieCredit(movieId: Int) {
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
