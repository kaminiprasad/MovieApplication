package com.movie.domain.entity.artist

data class Artist(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int,
)
