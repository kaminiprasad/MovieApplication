package com.movie.app.presentation.ui.viewmodel.moviedetail

import androidx.lifecycle.SavedStateHandle
import com.movie.app.presentation.ui.util.Constants.MOVIE_ID
import com.movie.domain.entity.artist.Artist
import com.movie.domain.entity.artist.Cast
import com.movie.domain.entity.artist.Crew
import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result
import com.movie.domain.usecase.artist.MovieArtistUseCase
import com.movie.domain.usecase.moviedetail.MovieDetailsUseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.* // ktlint-disable no-wildcard-imports
import org.junit.After
import org.junit.Before
import org.junit.Test

const val MOVIE_ARTIST_ID = "951539"

class MovieDetailViewModelTest {
    private val movieDetailUseCase: MovieDetailsUseCase = mockk()
    private val artistUseCase: MovieArtistUseCase = mockk()
    private lateinit var testDispatcher: TestDispatcher
    private lateinit var savedStateHandle: SavedStateHandle

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
        savedStateHandle = SavedStateHandle(mapOf(MOVIE_ID to MOVIE_ARTIST_ID))
    }

    @Test
    fun getMovieDetailTest() = runTest {
        val expectedResult = Result.Success(getMovieDetails())
        coEvery { movieDetailUseCase(MOVIE_ARTIST_ID.toInt()) } returns flowOf(expectedResult)

        // When
        val viewModel = MovieDetailViewModel(
            movieDetails = movieDetailUseCase,
            movieArtist = artistUseCase,
            savedStateHandle = savedStateHandle,
        )
        viewModel.getMovieById(MOVIE_ARTIST_ID.toInt())

        // Then
        viewModel.movieState.collectLatest {
            assert(it.movie?.originalTitle == "Wonka")
            assert(it.movie?.status == "Released")
            assert(it.movie?.voteAverage == 7.2)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieArtistTest() = runTest {
        val movieArtist = Artist(
            cast = getMovieCast(),
            crew = getMovieCrew(),
            id = 951546,
        )

        val expectedResult = Result.Success(movieArtist)
        coEvery { artistUseCase(MOVIE_ARTIST_ID.toInt()) } returns flowOf(expectedResult)

        // When
        val viewModel = MovieDetailViewModel(
            movieDetails = movieDetailUseCase,
            movieArtist = artistUseCase,
            savedStateHandle = savedStateHandle,
        )
        viewModel.movieCredit(MOVIE_ARTIST_ID.toInt())

        // Then
        viewModel.artistState.collectLatest {
            if (it.cast.isEmpty().not() && it.crew.isEmpty().not()) {
                assert(it.cast.first().name == "Mike Kelson")
                assert(it.cast.first().creditId == "6236aa8a54a8ac0046db8c0b")
                assert(it.crew.first().gender == 2)
                assert(it.crew.first().job == "Executive Producer")
            }
        }
    }

    private fun getMovieDetails() = MovieDetail(
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

    private fun getMovieCast(): MutableList<Cast> {
        val movieCast = mutableListOf<Cast>()
        val castMikeKelson = Cast(
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
        val castRitaSiddiqui = Cast(
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
        movieCast.add(castMikeKelson)
        movieCast.add(castRitaSiddiqui)
        return movieCast
    }

    private fun getMovieCrew(): MutableList<Crew> {
        val movieCrew = mutableListOf<Crew>()
        val crewScottChambers = Crew(
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
        val crewRebeccaMatthews = Crew(
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
        movieCrew.add(crewScottChambers)
        movieCrew.add(crewRebeccaMatthews)
        return movieCrew
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}
