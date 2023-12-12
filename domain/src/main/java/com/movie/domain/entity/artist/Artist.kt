package com.movie.domain.entity.artist

import com.movie.domain.util.Domain

data class Artist(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int,
) : Domain
