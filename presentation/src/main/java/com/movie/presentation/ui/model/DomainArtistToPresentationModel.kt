package com.movie.presentation.ui.model

data class DomainArtistToPresentationModel(
    val cast: List<DomainCastToPresentationModel>,
    val crew: List<DomainToCrewPresentationModel>,
    val id: Int,
)
