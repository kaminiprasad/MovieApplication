package com.movie.app.utils

import com.movie.domain.entity.artist.Artist
import com.movie.domain.entity.artist.Cast
import com.movie.domain.entity.artist.Crew
import com.movie.domain.entity.movie.Movie
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result
import com.movie.domain.repository.Repository
import kotlinx.coroutines.flow.flow

class FakeRepositoryImpl : Repository {
    private val castMikeKelson = Cast(
        adult = false,
        gender = 2,
        castId = 8,
        knownForDepartment = "Acting",
        name = "Mike Kelson",
        originalName = "Mike Kelson",
        popularity = 2.092,
        profilePath = "/gJTHA8ETJVzMAX8vrBrAfLcq92f.jpg",
        character = "Henry",
        creditId = "6236aa8a54a8ac0046db8c0b",
        id = 2305401,
        order = 6,
    )
    private val castRitaSiddiqui = Cast(
        adult = false,
        gender = 1,
        castId = 17,
        knownForDepartment = "Acting",
        name = "Rita Siddiqui",
        originalName = "Rita Siddiqui",
        popularity = 2.744,
        profilePath = "/3ept5pCLZ1a3xwJqvop27kjkqLb.jpg",
        character = "Alina",
        creditId = "628b93501a3248179737b918",
        id = 2040481,
        order = 12,
    )
    private val crewScottChambers = Crew(
        adult = false,
        gender = 2,
        creditId = "63eb1342699fb7007c5eb36b",
        department = "Production",
        id = 1482026,
        job = "Executive Producer",
        knownForDepartment = "Production",
        name = "Scott Chambers",
        originalName = "Scott Chambers",
        popularity = 3.775,
        profilePath = "/gnijb5Qu5xrswa3ctIc0re0w8dO.jpg",
    )
    private val crewRebeccaMatthews = Crew(
        adult = false,
        gender = 1,
        creditId = "63eb134f699fb70084e0c5e1",
        department = "Production",
        id = 1924465,
        job = "Casting",
        knownForDepartment = "Production",
        name = "Rebecca Matthews",
        originalName = "Rebecca Matthews",
        popularity = 2.041,
        profilePath = "/4cXC4goy1Stgk62cmEUIIVkBYZj.jpg",
    )
    private val movieTrolls = Movie(
        id = 897087,
        title = "Trolls Band Together",
        originalTitle = "Trolls Band Together",
        backdropPath = "/zIYROrkHJPYB3VTiW1L9QVgaQO.jpg",
        posterUrl = "/zDb5YeHSGGMlS6eqhUXcVU2OzAJ.jpg",
        voteAverage = 6.3,
        releaseDate = "2023-10-05",
    )
    private val movieKillers = Movie(
        id = 466420,
        title = "Killers of the Flower Moon",
        originalTitle = "Killers of the Flower Moon",
        backdropPath = "/1X7vow16X7CnCoexXh4H4F2yDJv.jpg",
        posterUrl = "/dB6Krk806zeqd0YNp2ngQ9zXteH.jpg",
        voteAverage = 7.687,
        releaseDate = "2023-10-18",
    )
    private val movieFreelance = Movie(
        id = 901362,
        title = "Freelance",
        originalTitle = "Freelance",
        backdropPath = "/k1KrbaCMACQiq7EA0Yhw3bdzMv7.jpg",
        posterUrl = "/sEaLO9s7CIN3fjz8R3Qksum44en.jpg",
        voteAverage = 7.150,
        releaseDate = "2023-10-12",
    )
    private val movieDetail = MovieDetail(
        id = 787699,
        backdropPath = "/yOm993lsJyPmBodlYjgpPwBjXP9.jpg",
        originalLanguage = "en",
        originalTitle = "Wonka",
        overview = "Willy Wonka – chock-full of ideas and determined to change the world",
        posterPath = "/qhb1qOilapbapxWQn9jtRCMwXJF.jpg",
        releaseDate = "2023-12-06",
        runtime = 117,
        status = "Released",
        tagline = "Every good thing in this world started with a dream.",
        title = "Wonka",
        video = false,
        voteAverage = 7.2,
        voteCount = 88,
    )
    private val popularMovies = listOf(movieTrolls, movieKillers, movieFreelance)
    private val movieArtist = Artist(
        cast = mutableListOf(castMikeKelson, castRitaSiddiqui),
        crew = mutableListOf(crewScottChambers, crewRebeccaMatthews),
        id = 951546,
    )

    override suspend fun getPopularMovies() =
        flow { emit(Result.Success(popularMovies)) }

    override suspend fun getMovieById(id: Int) = flow {
        emit(Result.Success(movieDetail))
    }

    override suspend fun getMovieCredit(movieId: Int) =
        flow { emit(Result.Success(movieArtist)) }
}
