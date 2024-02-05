package com.movie.domain.usecase.moviedetail

import com.movie.domain.entity.moviedetail.MovieDetail
import com.movie.domain.extension.Result

interface MovieDetailsUseCase {
    suspend operator fun invoke(id: Int): Result<MovieDetail>
}
