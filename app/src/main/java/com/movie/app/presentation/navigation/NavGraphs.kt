package com.movie.app.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.movie.app.presentation.ui.detailsscreen.MovieDetailScreen
import com.movie.app.presentation.ui.homescreen.HomeScreen
import com.movie.app.presentation.ui.util.Constants.MOVIE_ID

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
            HomeScreen(navController = navHostController)
        }
        composable(route = Screen.MovieItemDetail.route + "/{$MOVIE_ID}") {
            MovieDetailScreen()
        }
    }
}
