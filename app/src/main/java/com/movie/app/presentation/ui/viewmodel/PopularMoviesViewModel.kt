package com.movie.app.presentation.ui.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.domain.entity.Movie
import com.movie.domain.extension.Result
import com.movie.domain.usecase.popularmovie.GetPopularMovieUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val movieUseCase: GetPopularMovieUseCaseImpl
): ViewModel() {

    init {
        getMovieList()
    }

    private val _movieState: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val movieState: StateFlow<List<Movie>> = _movieState

    private val _loadingState = MutableStateFlow(true)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _errorState = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState

    @VisibleForTesting
    internal fun getMovieList() = viewModelScope.launch {
        movieUseCase().collectLatest {
            when(it) {
                is Result.Loading -> {
                    _loadingState.value = true
                }
                is Result.Success -> {
                    _loadingState.value = false
                    _movieState.value = it.data
                }
                is Result.Error -> {
                    _loadingState.value = false
                    _errorState.value = it.error
                }
            }
        }
    }
    fun refresh() = getMovieList()
}