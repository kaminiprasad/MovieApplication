package com.movie.app.utils

import com.movie.domain.entity.artist.Cast
import com.movie.domain.entity.artist.Crew
import com.movie.domain.entity.movie.Movie
import com.movie.domain.entity.moviedetail.MovieDetail

const val ARTIST_ID = 951546
const val EXECUTIVE_PRODUCER = "Executive Producer"
const val PRODUCTION = "Production"
const val CASTING = "Casting"
const val ACTING = "Acting"
const val SCOTT_CHAMBERS = "Scott Chambers"
const val SCOTT_CHAMBERS_PROFILE_PATH = "/gnijb5Qu5xrswa3ctIc0re0w8dO.jpg"
const val REBECCA_PROFILE_PATH = "/4cXC4goy1Stgk62cmEUIIVkBYZj.jpg"
const val REBECCA_MATTHEWS = "Rebecca Matthews"
const val MIKE_KELSON = "Mike Kelson"
const val MIKE_KELSON_POPULARITY = 2.092
const val MIKE_KELSON_PROFILE_PATH = "/gJTHA8ETJVzMAX8vrBrAfLcq92f.jpg"
const val MIKE_KELSON_CREDIT_ID = "6236aa8a54a8ac0046db8c0b"
const val MIKE_KELSON_ID = 2305401
const val MIKE_KELSON_CAST_ID = 8
const val MIKE_KELSON_ORDER = 6
const val HENRY = "Henry"
const val ALINA = "Alina"
const val RITA_SIDDIQUI = "Rita Siddiqui"
const val RITA_SIDDIQUI_POPULARITY = 2.744
const val RITA_SIDDIQUI_PROFILE_PATH = "/3ept5pCLZ1a3xwJqvop27kjkqLb.jpg"
const val RITA_SIDDIQUI_CREDIT_ID = "628b93501a3248179737b918"
const val RITA_SIDDIQUI_ID = 2040481
const val RITA_SIDDIQUI_ORDER = 12
const val RITA_SIDDIQUI_CAST_ID = 17
const val REBECCA_CREDIT_ID = "63eb134f699fb70084e0c5e1"
const val REBECCA_ID = 1924465
const val REBECCA_POPULARITY = 2.041
const val SCOTT_CHAMBERS_CREDIT_ID = "63eb1342699fb7007c5eb36b"
const val SCOTT_CHAMBERS_ID = 1482026
const val SCOTT_CHAMBERS_POPULARITY = 3.775
const val ADULT = false
const val MALE = 2
const val FEMALE = 1
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

fun getMovieCast(): MutableList<Cast> {
    val movieCast = mutableListOf<Cast>()
    val castMikeKelson = Cast(
        adult = ADULT,
        gender = MALE,
        castId = MIKE_KELSON_CAST_ID,
        knownForDepartment = ACTING,
        name = MIKE_KELSON,
        originalName = MIKE_KELSON,
        popularity = MIKE_KELSON_POPULARITY,
        profilePath = MIKE_KELSON_PROFILE_PATH,
        character = HENRY,
        creditId = MIKE_KELSON_CREDIT_ID,
        id = MIKE_KELSON_ID,
        order = MIKE_KELSON_ORDER,
    )
    val castRitaSiddiqui = Cast(
        adult = ADULT,
        gender = FEMALE,
        castId = RITA_SIDDIQUI_CAST_ID,
        knownForDepartment = ACTING,
        name = RITA_SIDDIQUI,
        originalName = RITA_SIDDIQUI,
        popularity = RITA_SIDDIQUI_POPULARITY,
        profilePath = RITA_SIDDIQUI_PROFILE_PATH,
        character = ALINA,
        creditId = RITA_SIDDIQUI_CREDIT_ID,
        id = RITA_SIDDIQUI_ID,
        order = RITA_SIDDIQUI_ORDER,
    )
    movieCast.add(castMikeKelson)
    movieCast.add(castRitaSiddiqui)
    return movieCast
}

fun getMovieCrew(): MutableList<Crew> {
    val movieCrew = mutableListOf<Crew>()
    val crewScottChambers = Crew(
        adult = ADULT,
        gender = MALE,
        creditId = SCOTT_CHAMBERS_CREDIT_ID,
        department = PRODUCTION,
        id = SCOTT_CHAMBERS_ID,
        job = EXECUTIVE_PRODUCER,
        knownForDepartment = PRODUCTION,
        name = SCOTT_CHAMBERS,
        originalName = SCOTT_CHAMBERS,
        popularity = SCOTT_CHAMBERS_POPULARITY,
        profilePath = SCOTT_CHAMBERS_PROFILE_PATH,
    )
    val crewRebeccaMatthews = Crew(
        adult = ADULT,
        gender = FEMALE,
        creditId = REBECCA_CREDIT_ID,
        department = PRODUCTION,
        id = REBECCA_ID,
        job = CASTING,
        knownForDepartment = PRODUCTION,
        name = REBECCA_MATTHEWS,
        originalName = REBECCA_MATTHEWS,
        popularity = REBECCA_POPULARITY,
        profilePath = REBECCA_PROFILE_PATH,
    )
    movieCrew.add(crewScottChambers)
    movieCrew.add(crewRebeccaMatthews)
    return movieCrew
}

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
