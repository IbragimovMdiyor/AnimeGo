package com.example.animego.data.utils.click_listener

import com.example.animego.presentation.homeScreen.models.Anime

interface AnimeOnClickListener {
    fun showAnimeInfo(anime: Anime)
//    abstract fun requireBinding(): Any
}

interface FavoriteOnClickListener {

    fun delete(anime: Anime)

    fun showAnimeInfo(anime: Anime)
}