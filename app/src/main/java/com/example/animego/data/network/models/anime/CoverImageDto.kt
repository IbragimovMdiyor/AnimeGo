package com.example.animego.data.network.models.anime

import com.google.gson.annotations.SerializedName

data class CoverImageDto(
    @SerializedName("large") var large: String?= null,
    @SerializedName("original") var original: String?= null,
    @SerializedName("small") var small: String?= null,
    @SerializedName("tiny") var tiny: String?= null
)