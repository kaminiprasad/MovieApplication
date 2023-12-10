package com.reachout.data.model.artist


import com.google.gson.annotations.SerializedName
import com.reachout.data.mapper.Dto
import com.reachout.data.util.notNull
import com.reachout.domain.entity.artist.Crew

data class CrewDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("credit_id")
    val creditId: String,
    @SerializedName("department")
    val department: String,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("job")
    val job: String,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String?
) : Dto {
    override fun asDomain() = Crew(
        adult,
        creditId,
        department,
        gender,
        id,
        job,
        knownForDepartment,
        name,
        originalName,
        popularity,
        profilePath.notNull()
    )
}