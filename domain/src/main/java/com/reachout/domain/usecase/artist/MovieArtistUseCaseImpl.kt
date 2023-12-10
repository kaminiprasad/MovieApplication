package com.reachout.domain.usecase.artist

import com.reachout.domain.entity.MovieDetail
import com.reachout.domain.entity.artist.Artist
import com.reachout.domain.extension.Result
import com.reachout.domain.repository.Repository
import com.reachout.domain.usecase.MovieDetailsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieArtistUseCaseImpl @Inject constructor(
    private val repository: Repository
) : MovieArtistUseCase {
    override suspend fun invoke(movieId: Int): Flow<Result<Artist>> {
        return repository.getMovieCredit(movieId)
    }
}