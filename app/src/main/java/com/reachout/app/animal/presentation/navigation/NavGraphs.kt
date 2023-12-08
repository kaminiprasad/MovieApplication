package com.reachout.app.animal.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.reachout.app.animal.presentation.ui.compose.HomeScreen

@ExperimentalFoundationApi
@Composable
fun NavGraphs(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navHostController)
        }
    }
}