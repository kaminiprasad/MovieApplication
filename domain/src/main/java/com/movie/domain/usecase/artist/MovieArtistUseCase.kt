package com.movie.domain.usecase.artist

import com.movie.domain.entity.artist.Artist
import com.movie.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface MovieArtistUseCase {
    suspend operator fun invoke(movieId : Int): Flow<Result<Artist>>
}