package com.movie.domain.repository

import com.movie.domain.extension.Result
import com.movie.domain.getMovieDetail
import com.movie.domain.movieArtist
import com.movie.domain.popularMovies
import kotlinx.coroutines.flow.flow

class MockMovieRepository : Repository {
    override suspend fun getPopularMovies() =
        flow { emit(Result.Success(popularMovies)) }

    override suspend fun getMovieById(id: Int) = flow {
        emit(Result.Success(getMovieDetail()))
    }

    override suspend fun getMovieCredit(movieId: Int) =
        flow { emit(Result.Success(movieArtist)) }
}
