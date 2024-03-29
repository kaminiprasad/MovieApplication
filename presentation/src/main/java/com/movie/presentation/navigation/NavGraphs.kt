package com.movie.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.movie.presentation.ui.detailsscreen.MovieDetailScreen
import com.movie.presentation.ui.homescreen.HomeScreen
import com.movie.presentation.ui.util.Constants.MOVIE_ID
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoilApi
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun NavGraphs(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen(onMovieItemClick = { navHostController.navigate(it) })
        }
        composable(route = Screen.MovieItemDetail.route + "/{$MOVIE_ID}") {
            MovieDetailScreen()
        }
    }
}
