package com.movie.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.domain.extension.Result
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import com.movie.presentation.ui.mapper.MovieDetailToPresentationMapperImpl
import com.movie.presentation.ui.model.MovieDetailFailure
import com.movie.presentation.ui.model.MovieDetailLoaded
import com.movie.presentation.ui.model.MovieDetailLoading
import com.movie.presentation.ui.model.MovieDetailUIState
import com.movie.presentation.ui.util.Constants.MOVIE_ID
import com.movie.presentation.ui.util.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val mapperImpl: MovieDetailToPresentationMapperImpl,
    private val movieDetails: MovieDetailsUseCase,
    private val contextProvider: CoroutineContextProvider = CoroutineContextProvider(),
    val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _movieState: MutableStateFlow<MovieDetailUIState> =
        MutableStateFlow(MovieDetailLoading)
    val movieState: StateFlow<MovieDetailUIState> = _movieState

    init {
        savedStateHandle.get<String>(MOVIE_ID)?.let {
            getMovieById(it.toInt())
        }
    }

    internal fun getMovieById(id: Int) {
        viewModelScope.launch(contextProvider.IO) {
            movieDetails(id = id).also { result ->
                when (result) {
                    is Result.Success -> {
                        _movieState.value = MovieDetailLoaded(movie = mapperImpl.map(result.data))
                    }

                    is Result.Error -> {
                        _movieState.value = MovieDetailFailure(error = result.error)
                    }
                }
            }
        }
    }
}
