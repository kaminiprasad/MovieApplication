package com.movie.presentation.ui.compose

import androidx.compose.animation.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.movie.presentation.R
import com.movie.presentation.ui.theme.DEFAULT_FONT_EXTRA_LARGE_SIZE
import com.movie.presentation.ui.theme.DEFAULT_PADDING_SMALL_SIZE
import com.movie.presentation.ui.theme.green
import com.movie.presentation.ui.theme.red
import com.movie.presentation.ui.util.isInternetConnectionAvailable
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun ConnectivityStatus(onRefresh: () -> Unit) {
    val updatedOnRefresh = rememberUpdatedState(onRefresh)
    val isConnected = LocalContext.current.isInternetConnectionAvailable()
    var visibility by remember { mutableStateOf(false) }

    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically(),
        exit = shrinkVertically(),
    ) {
        ConnectivityStatusBox(isConnected = isConnected)
    }

    LaunchedEffect(isConnected) {
        if (isConnected) {
            visibility = false
            updatedOnRefresh.value.invoke()
        } else {
            visibility = true
        }
    }
}

@Composable
fun ConnectivityStatusBox(isConnected: Boolean) {
    val backgroundColor by animateColorAsState(if (isConnected) green else red)
    val message =
        if (isConnected) {
            stringResource(R.string.internet_connection_available)
        } else {
            stringResource(
                R.string.internet_connection_not_available,
            )
        }
    val iconResource = if (isConnected) {
        android.R.drawable.ic_lock_idle_charging
    } else {
        android.R.drawable.ic_lock_idle_low_battery
    }

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