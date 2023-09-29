package com.example.animego.data.network.models.anime

import com.example.animego.presentation.homeScreen.models.Attributes
import java.io.Serializable

data class AnimeAddResponse(
    var animeId: String,
    var attributes: Attributes?,
    var type: String? = null,
) : Serializable
