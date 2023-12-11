package com.movie.app.presentation.ui.compose

import com.movie.app.R
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.movie.app.presentation.navigation.NavGraphs
import com.movie.app.presentation.ui.util.isMovieDetailPage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppContent(navHostController: NavHostController) {
    val materialBlue700 = Color(0xFF4321D2)
    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                navigationIcon = if (navBackStackEntry.isMovieDetailPage()
                ) {
                    {
                        IconButton(onClick = {
                            navHostController.navigateUp()
                        }) {
                            Icon(
                                tint = Color.White,
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = Icons.Filled.ArrowBack.name
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
                backgroundColor = materialBlue700
            )
        },
        content = { NavGraphs(navHostController = navHostController) }
    )
}