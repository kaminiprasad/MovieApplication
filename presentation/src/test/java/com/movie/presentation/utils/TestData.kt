package com.movie.presentation.utils

import com.movie.domain.entity.movie.Movie
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.presentation.ui.model.DomainMovieToPresentationModel
import com.movie.presentation.ui.model.MovieDetailToPresentationModel

const val MOVIE_ARTIST_ID = "951539"
const val MOVIE_DETAIL_ID = 787699
const val MOVIE_DETAIL_BACKDROP_PATH = "/yOm993lsJyPmBodlYjgpPwBjXP9.jpg"
const val MOVIE_DETAIL_ORIGINAL_LANGUAGE = "en"
const val MOVIE_DETAIL_TITLE = "Wonka"
const val MOVIE_DETAIL_OVERVIEW =
    "Willy Wonka – chock-full of ideas and determined to change the world"
const val MOVIE_DETAIL_POSTER_PATH = "/qhb1qOilapbapxWQn9jtRCMwXJF.jpg"
const val MOVIE_DETAIL_RELEASE_DATE = "2023-12-06"
const val MOVIE_DETAIL_RUNTIME = 117
const val MOVIE_DETAIL_STATUS = "Released"
const val MOVIE_DETAIL_TAGLINE = "Every good thing in this world started with a dream."
const val MOVIE_DETAIL_VIDEO = false
const val MOVIE_DETAIL_VOTE_AVERAGE = 7.2
const val MOVIE_DETAIL_VOTE_COUNT = 88
const val TROLLS_BAND_TOGETHER_ID = 897087
const val TROLLS_BAND_TOGETHER = "Trolls Band Together"
const val TROLLS_BACKDROP_PATH = "/zIYROrkHJPYB3VTiW1L9QVgaQO.jpg"
const val TROLLS_POSTER_URL = "/zDb5YeHSGGMlS6eqhUXcVU2OzAJ.jpg"
const val TROLLS_VOTE_AVERAGE = 6.3
const val TROLLS_RELEASE_DATE = "2023-10-05"
const val KILLERS_ID = 466420
const val KILLERS_TITLE = "Killers of the Flower Moon"
const val KILLERS_BACKDROP_PATH = "/1X7vow16X7CnCoexXh4H4F2yDJv.jpg"
const val KILLERS_POSTER_URL = "/dB6Krk806zeqd0YNp2ngQ9zXteH.jpg"
const val KILLERS_VOTE_AVERAGE = 7.687
const val KILLERS_RELEASE_DATE = "2023-10-18"
const val FREELANCE_ID = 901362
const val FREELANCE_TITLE = "Freelance"
const val FREELANCE_BACKDROP_PATH = "/k1KrbaCMACQiq7EA0Yhw3bdzMv7.jpg"
const val FREELANCE_POSTER_URL = "/sEaLO9s7CIN3fjz8R3Qksum44en.jpg"
const val FREELANCE_VOTE_AVERAGE = 7.150
const val FREELANCE_RELEASE_DATE = "2023-10-12"
fun getMovieDetail() = MovieDetail(
    id = MOVIE_DETAIL_ID,
    backdropPath = MOVIE_DETAIL_BACKDROP_PATH,
    originalLanguage = MOVIE_DETAIL_ORIGINAL_LANGUAGE,
    originalTitle = MOVIE_DETAIL_TITLE,
    overview = MOVIE_DETAIL_OVERVIEW,
    posterPath = MOVIE_DETAIL_POSTER_PATH,
    releaseDate = MOVIE_DETAIL_RELEASE_DATE,
    runtime = MOVIE_DETAIL_RUNTIME,
    status = MOVIE_DETAIL_STATUS,
    tagline = MOVIE_DETAIL_TAGLINE,
    title = MOVIE_DETAIL_TITLE,
    video = MOVIE_DETAIL_VIDEO,
    voteAverage = MOVIE_DETAIL_VOTE_AVERAGE,
    voteCount = MOVIE_DETAIL_VOTE_COUNT,
)

fun getPopularMovies() =
    listOf(
        Movie(
            id = TROLLS_BAND_TOGETHER_ID,
            title = TROLLS_BAND_TOGETHER,
            originalTitle = TROLLS_BAND_TOGETHER,
            backdropPath = TROLLS_BACKDROP_PATH,
            posterUrl = TROLLS_POSTER_URL,
            voteAverage = TROLLS_VOTE_AVERAGE,
            releaseDate = TROLLS_RELEASE_DATE,
        ),
        Movie(
            id = KILLERS_ID,
            title = KILLERS_TITLE,
            originalTitle = KILLERS_TITLE,
            backdropPath = KILLERS_BACKDROP_PATH,
            posterUrl = KILLERS_POSTER_URL,
            voteAverage = KILLERS_VOTE_AVERAGE,
            releaseDate = KILLERS_RELEASE_DATE,
        ),
        Movie(
            id = FREELANCE_ID,
            title = FREELANCE_TITLE,
            originalTitle = FREELANCE_TITLE,
            backdropPath = FREELANCE_BACKDROP_PATH,
            posterUrl = FREELANCE_POSTER_URL,
            voteAverage = FREELANCE_VOTE_AVERAGE,
            releaseDate = FREELANCE_RELEASE_DATE,
        ),
    )

fun getMovieDetailPresentation() = MovieDetailToPresentationModel(
    backdropPath = MOVIE_DETAIL_BACKDROP_PATH,
    originalLanguage = MOVIE_DETAIL_ORIGINAL_LANGUAGE,
    originalTitle = MOVIE_DETAIL_TITLE,
    overview = MOVIE_DETAIL_OVERVIEW,
    releaseDate = MOVIE_DETAIL_RELEASE_DATE,
    title = MOVIE_DETAIL_TITLE,
    voteAverage = MOVIE_DETAIL_VOTE_AVERAGE,
)

fun getPopularMoviesPresentation() =
    listOf(
        DomainMovieToPresentationModel(
            id = TROLLS_BAND_TOGETHER_ID,
            title = TROLLS_BAND_TOGETHER,
            originalTitle = TROLLS_BAND_TOGETHER,
            posterUrl = TROLLS_POSTER_URL,
            voteAverage = TROLLS_VOTE_AVERAGE,
            releaseDate = TROLLS_RELEASE_DATE,
        ),
        DomainMovieToPresentationModel(
            id = KILLERS_ID,
            title = KILLERS_TITLE,
            originalTitle = KILLERS_TITLE,
            posterUrl = KILLERS_POSTER_URL,
            voteAverage = KILLERS_VOTE_AVERAGE,
            releaseDate = KILLERS_RELEASE_DATE,
        ),
        DomainMovieToPresentationModel(
            id = FREELANCE_ID,
            title = FREELANCE_TITLE,
            originalTitle = FREELANCE_TITLE,
            posterUrl = FREELANCE_POSTER_URL,
            voteAverage = FREELANCE_VOTE_AVERAGE,
            releaseDate = FREELANCE_RELEASE_DATE,
        ),
    )
