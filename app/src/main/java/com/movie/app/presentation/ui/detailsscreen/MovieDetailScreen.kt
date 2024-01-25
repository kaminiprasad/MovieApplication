package com.movie.app.presentation.ui.detailsscreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.movie.app.R
import com.movie.app.presentation.ui.compose.CircularProgressBar
import com.movie.app.presentation.ui.compose.ConnectivityStatus
import com.movie.app.presentation.ui.compose.MovieDetailErrorComponent
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_EXTRA_LARGE_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_MEDIUM_SIZE
import com.movie.app.presentation.ui.theme.DEFAULT_PADDING_VERY_VERY_SMALL_SIZE
import com.movie.app.presentation.ui.theme.SIZE_240_DP
import com.movie.app.presentation.ui.theme.ratingStarColor
import com.movie.app.presentation.ui.util.Constants.IMAGE_URL
import com.movie.app.presentation.ui.util.connectivityState
import com.movie.app.presentation.ui.util.roundOff
import com.movie.app.presentation.ui.viewmodel.moviedetail.MovieDetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
@ExperimentalCoilApi
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel(),
) {
    val progressBar = remember {
        mutableStateOf(false)
    }
    val movieDetail = movieDetailViewModel.movieState.collectAsState()
    val artist = movieDetailViewModel.artistState.collectAsState()

    val status = movieDetailViewModel.loadingState.collectAsState()
    val state by connectivityState()
    SwipeRefresh(
        state = rememberSwipeRefreshState(status.value),
        onRefresh = { movieDetailViewModel.loadMovieDetailData() },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                CircularProgressBar(
                    isDisplayed = progressBar.value,
                    modifier = Modifier.testTag(stringResource(R.string.tag_progress_bar)),
                )
                MovieDetailErrorComponent()
                movieDetail.value.movie?.let {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        Image(
                            painter = rememberImagePainter(
                                data = IMAGE_URL.plus(it.backdropPath),
                                builder = {
                                    // Optional: Add image transformations
                                    placeholder(R.drawable.ic_launcher_foreground)
                                },
                            ),
                            contentDescription = it.originalTitle,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(SIZE_240_DP)
                                .padding(
                                    start = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                                    end = DEFAULT_PADDING_VERY_VERY_SMALL_SIZE,
                                )
                                .clip(MaterialTheme.shapes.large),
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    start = DEFAULT_PADDING_EXTRA_LARGE_SIZE,
                                    end = DEFAULT_PADDING_EXTRA_LARGE_SIZE,
                                ),
                        ) {
                            Text(
                                text = it.title,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .padding(DEFAULT_PADDING_MEDIUM_SIZE),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2,
                                style = MaterialTheme.typography.h4,
                                fontWeight = FontWeight.Bold,
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        bottom = DEFAULT_PADDING_MEDIUM_SIZE,
                                        top = DEFAULT_PADDING_MEDIUM_SIZE,
                                    ),
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    IconButton(
                                        enabled = false,
                                        onClick = {},
                                    ) {
                                        Icon(
                                            tint = Color.Black,
                                            imageVector = Icons.Filled.Language,
                                            contentDescription = Icons.Filled.Language.name,
                                        )
                                    }
                                    Text(
                                        text = it.originalLanguage,
                                        fontWeight = FontWeight.Bold,
                                    )
                                }
                                Column(
                                    Modifier.weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    IconButton(
                                        enabled = false,
                                        onClick = {},
                                    ) {
                                        Icon(
                                            tint = ratingStarColor,
                                            imageVector = Icons.Filled.Star,
                                            contentDescription = Icons.Filled.StarRate.name,
                                        )
                                    }
                                    Text(
                                        text = it.voteAverage.roundOff(),
                                        fontWeight = FontWeight.Bold,
                                    )
                                }
                                Column(
                                    Modifier.weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    IconButton(
                                        enabled = false,
                                        onClick = {},
                                    ) {
                                        Icon(
                                            tint = Color.Black,
                                            imageVector = Icons.Filled.DateRange,
                                            contentDescription = Icons.Filled.DateRange.name,
                                        )
                                    }
                                    Text(
                                        text = it.releaseDate,
                                        fontWeight = FontWeight.Bold,
                                    )
                                }
                            }
                            Text(
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .padding(DEFAULT_PADDING_MEDIUM_SIZE),
                                text = stringResource(R.string.description),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.h5,
                            )
                            Text(
                                text = it.overview,
                                modifier = Modifier.padding(DEFAULT_PADDING_MEDIUM_SIZE),
                            )
                            ArtistAndCrew(artist.value.cast)
                        }
                    }
                }
            }
            ConnectivityStatus(connection = state, onRefresh = { movieDetailViewModel.loadMovieDetailData() })
        }
    }
}
