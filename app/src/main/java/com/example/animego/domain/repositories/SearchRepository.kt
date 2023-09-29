package com.example.animego.domain.repositories

import androidx.paging.PagingData
import com.example.animego.data.network.models.anime.AnimeResponse
import com.example.animego.presentation.homeScreen.models.Anime
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SearchRepository {
    suspend fun searchAnime(page: Int, pageSize: Int, query: String): Response<AnimeResponse>

    fun createPagerSearch(query: String): Flow<PagingData<Anime>>
}