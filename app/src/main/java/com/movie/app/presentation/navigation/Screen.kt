package com.movie.app.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object MovieItemDetail : Screen(route = "movie_detail")
}
