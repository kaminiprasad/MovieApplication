package com.reachout.domain.entity.artist


import com.reachout.domain.Domain

data class Artist(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
) : Domain