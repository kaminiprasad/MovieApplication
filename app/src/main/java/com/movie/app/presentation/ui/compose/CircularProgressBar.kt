package com.movie.app.presentation.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_VERY_LARGE_SIZE

@Composable
fun CircularProgressBar(isDisplayed: Boolean, modifier: Modifier) {
    if (isDisplayed) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = DEFAULT_PADDING_VERY_LARGE_SIZE),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
            )
        }
    }
}
