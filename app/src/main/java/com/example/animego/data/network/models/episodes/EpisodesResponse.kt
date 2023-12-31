package com.example.animego.data.network.models.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesResponse(
    @SerializedName("data") var episodes: List<Episodes>? = null,
)