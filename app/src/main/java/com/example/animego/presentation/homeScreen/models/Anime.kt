package com.example.animego.presentation.homeScreen.models

import org.ocpsoft.prettytime.PrettyTime
import java.io.Serializable
import java.util.*

data class Anime(
    var animeId: String,
    var attributes: Attributes?,
    var createdAt: Date? = null,
    var objectId: String? = null,
    var type: String? = null,
    var updatedAt: String? = null,
) : Serializable {

    fun getCreatedAt(): String? {
        val prettyTime = PrettyTime(Locale("en"))
        return prettyTime.format(createdAt)
    }
}
