package com.example.animego.data.network.models.categories

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("attributes") var attributes: Attributes? = null,
    @SerializedName("id") var id: String? = null,
)