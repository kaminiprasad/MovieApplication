package com.movie.data

import com.movie.data.model.artist.CastDto
import com.movie.data.model.artist.CrewDto
import com.movie.data.model.moviedetail.MovieDetailDto
import com.movie.data.model.moviedetail.MovieDto

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
const val MOVIE_ID = 897087
const val MOVIE_TITLE = "Trolls Band Together"
const val MOVIE_BACKDROP_PATH = "/zIYROrkHJPYB3VTiW1L9QVgaQO.jpg"
const val MOVIE_POSTER_URL = "/zDb5YeHSGGMlS6eqhUXcVU2OzAJ.jpg"
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

fun getMovieCrewDto(): MutableList<CrewDto> {
    val movieCrewDto = mutableListOf<CrewDto>()
    val crewScottChambers = CrewDto(
        adult = ADULT,
        gender = FEMALE,
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
    val crewRebeccaMatthews = CrewDto(
        adult = ADULT,
        gender = MALE,
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
    movieCrewDto.add(crewScottChambers)
    movieCrewDto.add(crewRebeccaMatthews)
    return movieCrewDto
}

fun getMovieCastDto(): MutableList<CastDto> {
    val movieCastDto = mutableListOf<CastDto>()
    val castMikeKelson = CastDto(
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
    val castRitaSiddiqui = CastDto(
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
    movieCastDto.add(castMikeKelson)
    movieCastDto.add(castRitaSiddiqui)
    return movieCastDto
}

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
