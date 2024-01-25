package com.movie.app.presentation.ui.model

data class DomainArtistToPresentationModel(
    val cast: List<DomainCastToPresentationModel>,
    val crew: List<DomainToCrewPresentationModel>,
    val id: Int,
)
