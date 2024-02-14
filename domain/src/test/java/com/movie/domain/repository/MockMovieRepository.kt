package com.movie.domain.repository

import com.movie.domain.extension.Result
import com.movie.domain.getMovieDetail
import com.movie.domain.popularMovies

class MockMovieRepository : Repository {
    override suspend fun getPopularMovies() =
        Result.Success(popularMovies)

    override suspend fun getMovieById(id: Int) =
        Result.Success(getMovieDetail())
}
