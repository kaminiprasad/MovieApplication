package com.movie.data.model.artist

import com.google.gson.annotations.SerializedName

data class ArtistDto(
    @SerializedName("cast")
    val cast: List<CastDto>,
    @SerializedName("crew")
    val crew: List<CrewDto>,
    @SerializedName("id")
    val id: Int,
)
