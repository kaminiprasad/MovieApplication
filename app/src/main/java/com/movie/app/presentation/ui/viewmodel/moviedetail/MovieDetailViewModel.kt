package com.movie.app.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.app.presentation.ui.compose.MovieDetailState
import com.movie.app.presentation.ui.mapper.DomainArtistToPresentationMapperImpl
import com.movie.app.presentation.ui.mapper.MovieDetailToPresentationMapperImpl
import com.movie.app.presentation.ui.model.DomainArtistToPresentationModel
import com.movie.app.presentation.ui.util.Constants.MOVIE_ID
import com.movie.app.presentation.ui.util.CoroutineContextProvider
import com.movie.domain.extension.Result
import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val artistMapperImpl: DomainArtistToPresentationMapperImpl,
    private val mapperImpl: MovieDetailToPresentationMapperImpl,
    private val movieDetails: MovieDetailsUseCase,
    private val movieArtist: MovieArtistUseCase,
    private val contextProvider: CoroutineContextProvider = CoroutineContextProvider(),
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _movieState: MutableStateFlow<MovieDetailState> =
        MutableStateFlow(MovieDetailState())
    val movieState: StateFlow<MovieDetailState> = _movieState

    private val _artistState: MutableStateFlow<DomainArtistToPresentationModel> =
        MutableStateFlow(
            DomainArtistToPresentationModel(
                cast = emptyList(),
                crew = emptyList(),
                id = -1
            )
        )
    val artistState: StateFlow<DomainArtistToPresentationModel> = _artistState

    private val _loadingState = MutableStateFlow(true)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _errorState = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState

    internal fun getMovieById(id: Int) = viewModelScope.launch(contextProvider.IO) {
        movieDetails(id = id).collectLatest {
            when (it) {
                is Result.Loading -> {
                    _loadingState.value = true
                }

                is Result.Success -> {
                    _loadingState.value = false
                    _movieState.value = MovieDetailState(
                        movie = mapperImpl.map(it.data),
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

    internal fun movieCredit(movieId: Int) =
        viewModelScope.launch(contextProvider.IO) {
            movieArtist(movieId).collectLatest {
                when (it) {
                    is Result.Loading -> {
                        _loadingState.value = true
                    }

                    is Result.Success -> {
                        _loadingState.value = false
                        _artistState.value = artistMapperImpl.map(it.data)
                    }

                    is Result.Error -> {
                        _loadingState.value = true
                        _errorState.value = it.error
                        _artistState.value = DomainArtistToPresentationModel(
                            cast = emptyList(),
                            crew = emptyList(),
                            id = -1
                        )
                    }

                    else -> {}
                }
            }
    }

    fun loadMovieDetailData() {
        savedStateHandle.get<String>(MOVIE_ID)?.let {
            getMovieById(it.toInt())
            movieCredit(it.toInt())
        }
    }
}
