package com.movie.data.model.artist

import com.google.gson.annotations.SerializedName
import com.movie.data.mapper.Dto
import com.movie.data.util.notNull
import com.movie.domain.entity.artist.Cast

data class CastDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("cast_id")
    val castId: Int,
    @SerializedName("character")
    val character: String,
    @SerializedName("credit_id")
    val creditId: String,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String?,
) : Dto {
    override fun asDomain() = Cast(
        adult,
        castId,
        character,
        creditId,
        gender,
        id,
        knownForDepartment,
        name,
        order,
        originalName,
        popularity,
        profilePath.notNull(),
    )
}
