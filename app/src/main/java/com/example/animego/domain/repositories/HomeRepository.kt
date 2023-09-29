package com.example.animego.domain.repositories

import androidx.paging.PagingData
import com.example.animego.data.network.models.anime.AnimeResponse
import com.example.animego.presentation.homeScreen.models.Anime
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface HomeRepository {
    suspend fun getAllAnime(
        pageSize: Int,
        page: Int
    ): Response<AnimeResponse>

    fun createPagerAnime(): Flow<PagingData<Anime>>

}