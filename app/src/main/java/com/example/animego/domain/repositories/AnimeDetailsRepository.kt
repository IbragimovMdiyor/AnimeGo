package com.example.animego.domain.repositories

import androidx.paging.PagingData
import com.example.animego.data.network.models.castings.CastingsResponse
import com.example.animego.data.network.models.categories.CategoriesResponse
import com.example.animego.data.network.models.episodes.Episodes
import com.example.animego.data.network.models.episodes.EpisodesResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface AnimeDetailsoRepository {
    suspend fun getEpisodesAnime(id: Int, page: Int, pageSize: Int): Response<EpisodesResponse>

    suspend fun getCastingsAnime(id: Int): Response<CastingsResponse>

    suspend fun getCategoriesAnime(id: Int): Response<CategoriesResponse>


    fun createPagerAnimeEpisode(id: Int): Flow<PagingData<Episodes>>
}