package com.movie.presentation.navigation

import com.movie.presentation.ui.util.Constants.HOME_SCREEN
import com.movie.presentation.ui.util.Constants.MOVIE_DETAIL

sealed class Screen(val route: String) {
    object Home : Screen(route = HOME_SCREEN)
    object MovieItemDetail : Screen(route = MOVIE_DETAIL)
}
