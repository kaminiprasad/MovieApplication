package com.reachout.app.animal.presentation.ui.detailsscreen

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
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.reachout.app.R
import com.reachout.app.animal.presentation.ui.util.Constants.PROFILE_PATH_URL
import com.reachout.domain.entity.artist.Cast

@Composable
fun ArtistAndCrew(cast: List<Cast>) {
    Column(modifier = Modifier.padding(bottom = 10.dp)) {
        Text(
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .padding(10.dp),
            text = stringResource(R.string.cast),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5
        )
        LazyRow {
            items(cast, itemContent = { item ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = rememberImagePainter(
                            data = PROFILE_PATH_URL.plus(item.profilePath),
                            builder = {
                                // Optional: Add image transformations
                                placeholder(R.drawable.ic_launcher_foreground)
                            }
                        ),
                        contentDescription = item.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(240.dp)
                            .width(180.dp)
                            .padding(
                                end = 10.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            )
                            .clip(shape = MaterialTheme.shapes.large)
                            .clickable(enabled = false,
                                onClick = {})
                    )
                    Text(
                        text = item.name,
                        modifier = Modifier.padding(
                            end = 10.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        )
                    )
                }

            })
        }
    }
}