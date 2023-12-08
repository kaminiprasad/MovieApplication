package com.reachout.app.animal.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.reachout.app.animal.presentation.ui.compose.AppContent
import com.reachout.app.animal.presentation.ui.theme.AnimalZooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalZooTheme {
                navHostController = rememberNavController()
                AppContent(navHostController = navHostController)
            }
        }
    }
}