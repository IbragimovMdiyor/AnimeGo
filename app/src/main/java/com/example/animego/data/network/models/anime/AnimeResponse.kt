package com.example.animego.data.network.models.anime

import com.google.gson.annotations.SerializedName

data class AnimeResponse (
    @SerializedName("data") var anime: List<AnimeDto>?=null
        )