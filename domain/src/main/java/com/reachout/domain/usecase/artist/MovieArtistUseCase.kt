package com.reachout.domain.usecase.artist

import com.reachout.domain.entity.artist.Artist
import com.reachout.domain.extension.Result
import kotlinx.coroutines.flow.Flow

interface MovieArtistUseCase {
    suspend operator fun invoke(movieId : Int): Flow<Result<Artist>>
}