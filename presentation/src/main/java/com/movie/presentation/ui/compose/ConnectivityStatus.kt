package com.movie.presentation.ui.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.movie.presentation.R
import com.movie.presentation.ui.theme.DEFAULT_FONT_EXTRA_LARGE_SIZE
import com.movie.presentation.ui.theme.DEFAULT_PADDING_SMALL_SIZE
import com.movie.presentation.ui.theme.red
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun ConnectivityStatusBox() {
    val backgroundColor by animateColorAsState(red)
    val message =
        stringResource(
            R.string.internet_connection_not_available,
        )
    val iconResource =
        android.R.drawable.ic_lock_idle_low_battery

    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .padding(DEFAULT_PADDING_SMALL_SIZE),
        contentAlignment = Alignment.Center,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = iconResource),
                stringResource(R.string.connectivity_icon),
                tint = Color.White,
            )
            Spacer(modifier = Modifier.size(DEFAULT_PADDING_SMALL_SIZE))
            Text(message, color = Color.White, fontSize = DEFAULT_FONT_EXTRA_LARGE_SIZE)
        }
    }
}
