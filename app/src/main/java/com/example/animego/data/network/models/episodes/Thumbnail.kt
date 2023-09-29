package com.example.animego.data.network.models.episodes

import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("original") var original: String? = null,
)