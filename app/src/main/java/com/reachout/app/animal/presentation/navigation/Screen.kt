package com.reachout.app.animal.presentation.navigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Details : Screen(route = "details_screen/{heroId}") {
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }
}