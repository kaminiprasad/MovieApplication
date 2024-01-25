package com.movie.app.presentation.ui.viewmodel.popularmovie

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.app.presentation.ui.mapper.DomainMovieToPresentationMapperImpl
import com.movie.app.presentation.ui.model.DomainMovieToPresentationModel
import com.movie.app.presentation.ui.util.CoroutineContextProvider
import com.movie.domain.extension.Result
import com.movie.domain.usecase.popularmovie.PopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val presentationMovieListMapperImpl: DomainMovieToPresentationMapperImpl,
    private val movieUseCase: PopularMovieUseCase,
    private val coroutineContextProvider: CoroutineContextProvider = CoroutineContextProvider(),
) : ViewModel() {

    private val _movieState: MutableStateFlow<List<DomainMovieToPresentationModel>> =
        MutableStateFlow(emptyList())
    val movieState: StateFlow<List<DomainMovieToPresentationModel>> = _movieState

    private val _loadingState = MutableStateFlow(true)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _errorState = MutableStateFlow("")
    val errorState: StateFlow<String> = _errorState

    @VisibleForTesting
    internal fun getMovieList() = viewModelScope.launch(coroutineContextProvider.IO) {
        movieUseCase().collectLatest {
            when (it) {
                is Result.Loading -> {
                    _loadingState.value = true
                }

                is Result.Success -> {
                    _loadingState.value = false
                    _movieState.value = presentationMovieListMapperImpl.map(it.data)
                }

                is Result.Error -> {
                    _loadingState.value = false
                    _errorState.value = it.error
                }

                is Result.Empty -> {
                    // No implementation
                }
            }
        }
    }

    fun loadMovieData() = getMovieList()
}
