package com.movie.data

import com.movie.data.model.moviedetail.MovieDetailDto
import com.movie.data.model.moviedetail.MovieDto

const val RITA_SIDDIQUI_POPULARITY = 2.744
const val ADULT = false
const val MOVIE_ID = 897087
const val MOVIE_TITLE = "Trolls Band Together"
const val MOVIE_BACKDROP_PATH = "/zIYROrkHJPYB3VTiW1L9QVgaQO.jpg"
const val MOVIE_VOTE_AVERAGE = 6.3
const val MOVIE_RELEASE_DATE = "2023-10-05"
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

fun getMovieDetailsDto() = MovieDetailDto(
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

fun getMovieDto() = MovieDto(
    id = MOVIE_ID,
    title = MOVIE_TITLE,
    originalTitle = MOVIE_TITLE,
    backdropPath = MOVIE_BACKDROP_PATH,
    adult = ADULT,
    voteAverage = MOVIE_VOTE_AVERAGE,
    releaseDate = MOVIE_RELEASE_DATE,
    video = MOVIE_DETAIL_VIDEO,
    voteCount = MOVIE_DETAIL_VOTE_COUNT,
    posterPath = MOVIE_DETAIL_POSTER_PATH,
    popularity = RITA_SIDDIQUI_POPULARITY,
    overview = MOVIE_DETAIL_OVERVIEW,
    originalLanguage = MOVIE_DETAIL_ORIGINAL_LANGUAGE,
    genreIds = listOf(),
)
