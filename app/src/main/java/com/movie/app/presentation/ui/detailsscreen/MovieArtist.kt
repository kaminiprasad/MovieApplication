package com.movie.app.presentation.ui.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.movie.app.R
import com.movie.app.presentation.ui.model.DomainCastToPresentationModel
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_MEDIUM_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_VERY_VERY_SMALL_SIZE
import com.movie.app.presentation.ui.theme.SIZE_180_DP
import com.movie.app.presentation.ui.theme.SIZE_240_DP
import com.movie.app.presentation.ui.util.Constants.PROFILE_PATH_URL

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ArtistAndCrew(cast: List<DomainCastToPresentationModel>) {
    Column(modifier = Modifier.padding(bottom = DEFAULT_PADDING_MEDIUM_SIZE)) {
        Text(
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .padding(DEFAULT_PADDING_MEDIUM_SIZE),
            text = stringResource(R.string.cast),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
        )
        LazyRow {
            items(
                cast,
                itemContent = { item ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = rememberImagePainter(
                                data = PROFILE_PATH_URL.plus(item.profilePath),
                                builder = {
                                    // Optional: Add image transformations
                                    placeholder(R.drawable.ic_launcher_foreground)
                                },
                            ),
                            contentDescription = item.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(SIZE_240_DP)
                                .width(SIZE_180_DP)
                                .padding(
                                    end = DEFAULT_PADDING_MEDIUM_SIZE,
                                    top = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                                    bottom = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                                )
                                .clip(shape = MaterialTheme.shapes.large)
                                .clickable(
                                    enabled = false,
                                    onClick = {},
                                ),
                        )
                        Text(
                            text = item.name,
                            modifier = Modifier.padding(
                                end = DEFAULT_PADDING_MEDIUM_SIZE,
                                top = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                                bottom = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                            ),
                        )
                    }
                },
            )
        }
    }
}
