package com.movie.app.presentation.ui.homescreen

import androidx.compose.foundation.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.movie.app.R
import com.movie.app.presentation.ui.theme.ratingStarColor
import com.movie.app.presentation.ui.util.Constants
import com.movie.app.presentation.ui.util.roundOff
import com.movie.domain.entity.movie.Movie

@Composable
fun PopularMoviesItem(
    popular: Movie,
    onClick: (Movie) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .clickable {
                onClick(popular)
            },
    ) {
        Image(
            painter = rememberImagePainter(
                data = Constants.IMAGE_URL + popular.posterUrl,
                builder = {
                    // Optional: Add image transformations
                    placeholder(R.drawable.ic_launcher_foreground)
                },
            ),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .border(BorderStroke(1.dp, Color.White))
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White),
            contentDescription = popular.originalTitle,
        )
        Column {
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle()) {
                    append(popular.originalTitle)
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                    ),
                ) {
                    append(" (${popular.title}) ")
                }
            }
            Text(
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                text = annotatedString,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp),
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = Icons.Filled.Star.name,
                    tint = ratingStarColor,
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            top = 12.dp,
                        )
                        .size(16.dp),
                )
                Text(
                    text = popular.voteAverage.roundOff().plus(" IMDb"),
                    modifier = Modifier.padding(
                        top = 12.dp,
                        start = 4.dp,
                    ),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = Icons.Filled.DateRange.name,
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            top = 12.dp,
                        )
                        .size(24.dp),
                )
                Text(
                    text = popular.releaseDate,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        top = 12.dp,
                        start = 4.dp,
                    ),
                )
            }
        }
    }
}
