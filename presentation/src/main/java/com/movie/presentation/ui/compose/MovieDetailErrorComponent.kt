package com.movie.presentation.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.movie.presentation.ui.viewmodel.moviedetail.MovieDetailViewModel

@Composable
fun MovieDetailErrorComponent(
    viewModel: MovieDetailViewModel = hiltViewModel(),
) {
    val result = viewModel.movieState.collectAsState()
    val status = viewModel.loadingState.collectAsState()
    val error = viewModel.errorState.collectAsState()

    if (status.value.not() && result.value.movie == null) {
        Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Red,
                text = error.value,
            )
        }
    }
}
