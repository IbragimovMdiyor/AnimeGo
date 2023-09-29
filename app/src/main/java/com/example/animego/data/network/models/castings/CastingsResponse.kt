package com.example.animego.data.network.models.castings

import com.google.gson.annotations.SerializedName

data class CastingsResponse(
    @SerializedName("data")
    var castings: List<Castings>? = null,
)