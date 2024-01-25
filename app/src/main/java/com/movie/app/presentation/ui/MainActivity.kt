package com.movie.app.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.movie.app.presentation.ui.compose.AppContent
import com.movie.app.presentation.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                navHostController = rememberNavController()
                AppContent(navHostController = navHostController)
            }
        }
    }
}
