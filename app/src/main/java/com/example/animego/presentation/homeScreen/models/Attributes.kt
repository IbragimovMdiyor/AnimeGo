package com.example.animego.presentation.homeScreen.models

data class Attributes(
    var abbreviatedTitles: List<String>?,
    var ageRating: String?,
    var ageRatingGuide: String?,
    var averageRating: String?,
    var canonicalTitle: String?,
    var coverImage: CoverImage?,
    var coverImageTopOffset: Int?,
    var createdAt: String?,
    var description: String?,
    var endDate: String?,
    var episodeCount: Int?,
    var episodeLength: Int?,
    var favoritesCount: Int?,
    var nsfw: Boolean?,
    var popularityRank: Int?,
    var posterImage: PosterImage?,
    var ratingRank: Int?,
    var showType: String?,
    var slug: String?,
    var startDate: String?,
    var status: String?,
    var subtype: String?,
    var synopsis: String?,
    var titles: Titles?,
    var totalLength: Int?,
    var updatedAt: String?,
    var userCount: Int?,
    var youtubeVideoId: String?,
)