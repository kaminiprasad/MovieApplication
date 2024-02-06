package com.movie.presentation.ui.homescreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.movie.presentation.R
import com.movie.presentation.navigation.Screen
import com.movie.presentation.ui.compose.CircularProgressBar
import com.movie.presentation.ui.compose.ConnectivityStatus
import com.movie.presentation.ui.compose.ErrorComponent
import com.movie.presentation.ui.viewmodel.popularmovie.PopularMoviesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalCoilApi
@Composable
fun HomeScreen(
    onMovieItemClick: (String) -> Unit,
    viewModel: PopularMoviesViewModel = hiltViewModel(),
) {
    val result = viewModel.movieState.collectAsState()
    val status = viewModel.loadingState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        CircularProgressBar(
            isDisplayed = status.value,
            modifier = Modifier.testTag(stringResource(R.string.tag_progress_bar)),
        )
        ErrorComponent()
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            modifier = Modifier.testTag(stringResource(R.string.popular_movie_screen_tag)),
        ) {
            items(
                items = result.value,
                itemContent = { item ->
                    PopularMoviesItem(
                        popular = item,
                        onClick = {
                            onMovieItemClick(Screen.MovieItemDetail.route + "/${item.id}")
                        },
                    )
                },
            )
        }
        ConnectivityStatus(onRefresh = { viewModel.loadMovieData() })
    }
}
