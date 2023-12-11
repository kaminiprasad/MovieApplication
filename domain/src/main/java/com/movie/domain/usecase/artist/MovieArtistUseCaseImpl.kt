package com.movie.domain.usecase.artist

import com.movie.domain.entity.artist.Artist
import com.movie.domain.extension.Result
import com.movie.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieArtistUseCaseImpl @Inject constructor(
    private val repository: Repository
) : MovieArtistUseCase {
    override suspend fun invoke(movieId: Int): Flow<Result<Artist>> {
        return repository.getMovieCredit(movieId)
    }
}