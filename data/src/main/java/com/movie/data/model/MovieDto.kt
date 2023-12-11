package com.movie.data.model

import com.google.gson.annotations.SerializedName
import com.movie.data.mapper.Dto
import com.movie.data.util.notNull
import com.movie.domain.entity.Movie

data class MovieDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Dto {
    override fun asDomain() = Movie(
        id = id,
        title = title,
        originalTitle = originalTitle,
        backdropPath = backdropPath,
        posterUrl = posterPath,
        voteAverage = voteAverage,
        releaseDate = releaseDate.notNull()
    )
}