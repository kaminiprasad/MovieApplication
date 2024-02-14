package com.movie.presentation.ui.viewmodel.popularmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.domain.extension.Result
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import com.movie.presentation.ui.mapper.DomainMovieToPresentationMapperImpl
import com.movie.presentation.ui.model.MovieFailure
import com.movie.presentation.ui.model.MovieListUIState
import com.movie.presentation.ui.model.MoviesLoaded
import com.movie.presentation.ui.model.MoviesLoading
import com.movie.presentation.ui.util.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val presentationMovieListMapperImpl: DomainMovieToPresentationMapperImpl,
    private val movieUseCase: PopularMovieUseCase,
    private val coroutineContextProvider: CoroutineContextProvider = CoroutineContextProvider(),
) : ViewModel() {

    private val _movieState: MutableStateFlow<MovieListUIState> = MutableStateFlow(MoviesLoading)
    val movieState: StateFlow<MovieListUIState> = _movieState

    init {
        getMovieList()
    }

    internal fun getMovieList() {
        viewModelScope.launch(coroutineContextProvider.IO) {
            movieUseCase().also { result ->
                when (result) {
                    is Result.Success -> {
                        _movieState.value =
                            MoviesLoaded(presentationMovieListMapperImpl.map(result.data))
                    }

                    is Result.Error -> {
                        _movieState.value = MovieFailure(result.error)
                    }
                }
            }
        }
    }
}
