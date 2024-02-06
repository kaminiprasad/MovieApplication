package com.movie.presentation.ui.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.annotation.ExperimentalCoilApi
import com.movie.presentation.R
import com.movie.presentation.navigation.NavGraphs
import com.movie.presentation.ui.theme.materialBlue700
import com.movie.presentation.ui.util.isMovieDetailPage
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun AppContent(navHostController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                navigationIcon = if (navBackStackEntry.isMovieDetailPage()
                ) {
                    {
                        IconButton(
                            onClick = {
                                navHostController.navigateUp()
                            },
                        ) {
                            Icon(
                                tint = Color.White,
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = Icons.Filled.ArrowBack.name,
                            )
                        }
                    }
                } else {
                    null
                },
                title = {
                    Text(
                        if (navBackStackEntry.isMovieDetailPage()) {
                            stringResource(R.string.movie_detail)
                        } else {
                            stringResource(R.string.movie_home)
                        },
                        color = Color.White,
                    )
                },
                backgroundColor = materialBlue700,
            )
        },
        content = { NavGraphs(navHostController = navHostController) },
    )
}
