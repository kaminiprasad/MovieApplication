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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.movie.app.R
import com.movie.app.presentation.ui.model.DomainMovieToPresentationModel
import com.movie.app.presentation.ui.theme.DEFAULT_FONT_EXTRA_LARGE_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_FONT_VERY_LARGE_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_EXTRA_LARGE_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_LARGE_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_SMALL_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_VERY_SMALL_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_VERY_VERY_LARGE_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_VERY_VERY_SMALL_SIZE
import com.movie.app.presentation.ui.theme.SIZE_150_DP
import com.movie.app.presentation.ui.theme.VERY_VERY_TINY_SIZE
import com.movie.app.presentation.ui.theme.ratingStarColor
import com.movie.app.presentation.ui.util.Constants
import com.movie.app.presentation.ui.util.Constants.EMPTY_STRING
import com.movie.app.presentation.ui.util.roundOff

@ExperimentalCoilApi
@Composable
fun PopularMoviesItem(
    popular: DomainMovieToPresentationModel,
    onClick: (DomainMovieToPresentationModel) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(DEFAULT_PADDING_VERY_SMALL_SIZE)
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
                .size(SIZE_150_DP)
                .border(BorderStroke(VERY_VERY_TINY_SIZE, Color.White))
                .clip(RoundedCornerShape(DEFAULT_PADDING_EXTRA_LARGE_SIZE))
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
                        fontSize = DEFAULT_FONT_EXTRA_LARGE_SIZE,
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
                fontSize = DEFAULT_FONT_VERY_LARGE_SIZE,
                modifier = Modifier.padding(start = DEFAULT_PADDING_SMALL_SIZE),
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
                            start = DEFAULT_PADDING_SMALL_SIZE,
                            top = DEFAULT_PADDING_LARGE_SIZE,
                        )
                        .size(DEFAULT_PADDING_EXTRA_LARGE_SIZE),
                )
                Text(
                    text = popular.voteAverage.roundOff().plus(EMPTY_STRING).plus(stringResource(R.string.imdb)),
                    modifier = Modifier.padding(
                        top = DEFAULT_PADDING_LARGE_SIZE,
                        start = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                    ),
                    fontSize = DEFAULT_FONT_EXTRA_LARGE_SIZE,
                    textAlign = TextAlign.Center,
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = Icons.Filled.DateRange.name,
                    modifier = Modifier
                        .padding(
                            start = DEFAULT_PADDING_SMALL_SIZE,
                            top = DEFAULT_PADDING_LARGE_SIZE,
                        )
                        .size(DEFAULT_PADDING_VERY_VERY_LARGE_SIZE),
                )
                Text(
                    text = popular.releaseDate,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        top = DEFAULT_PADDING_LARGE_SIZE,
                        start = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                    ),
                )
            }
        }
    }
}
