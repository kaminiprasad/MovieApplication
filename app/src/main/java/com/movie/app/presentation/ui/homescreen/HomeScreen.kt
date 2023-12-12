package com.movie.app.presentation.ui.homescreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.movie.app.presentation.navigation.Screen
import com.movie.app.presentation.ui.compose.CircularProgressBar
import com.movie.app.presentation.ui.compose.ConnectivityStatus
import com.movie.app.presentation.ui.compose.ErrorComponent
import com.movie.app.presentation.ui.util.connectivityState
import com.movie.app.presentation.ui.viewmodel.PopularMoviesViewModel

@OptIn(ExperimentalAnimationApi::class, kotlinx.coroutines.ExperimentalCoroutinesApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: PopularMoviesViewModel = hiltViewModel(),
) {
    val result = viewModel.movieState.collectAsState()
    val status = viewModel.loadingState.collectAsState()

    val state by connectivityState()
    SwipeRefresh(
        state = rememberSwipeRefreshState(status.value),
        onRefresh = { viewModel.refresh() },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            CircularProgressBar(
                isDisplayed = status.value,
                modifier = Modifier.testTag("progress_bar"),
            )
            ErrorComponent()
            val listState = rememberLazyListState()
            LazyColumn(
                state = listState,
                modifier = Modifier.testTag("popular-movie-screenTag"),
            ) {
                items(
                    items = result.value,
                    itemContent = { item ->
                        PopularMoviesItem(
                            popular = item,
                            onClick = {
                                navController.navigate(Screen.MovieItemDetail.route + "/${item.id}")
                            },
                        )
                    },
                )
            }
            ConnectivityStatus(connection = state, onRefresh = { viewModel.refresh() })
        }
    }
}
