package com.example.animego.data.network

import com.example.animego.data.network.models.anime.AnimeResponse
import com.example.animego.data.network.models.castings.CastingsResponse
import com.example.animego.data.network.models.categories.CategoriesResponse
import com.example.animego.data.network.models.episodes.EpisodesResponse
import com.example.animego.data.utils.utils.Utils.ANIME_ID_CASTINGS_KEY
import com.example.animego.data.utils.utils.Utils.ANIME_ID_CATEGORIES_KEY
import com.example.animego.data.utils.utils.Utils.ANIME_ID_EPISODES_KEY
import com.example.animego.data.utils.utils.Utils.ANIME_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApi {
    @GET(ANIME_KEY)
    suspend fun getAllAnime(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset") page: Int,
    ): Response<AnimeResponse>

    @GET(ANIME_KEY)
    suspend fun searchAnime(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset]") page: Int,
        @Query("filter[text]") query: String,
    ): Response<AnimeResponse>

    @GET(ANIME_ID_EPISODES_KEY)
    suspend fun getEpisodesAnime(
        @Path("id") id: Int,
        @Query("page[offset]") page: Int,
        @Query("page[limit]") pageSize: Int,
    ): Response<EpisodesResponse>


    @GET(ANIME_ID_CASTINGS_KEY)
    suspend fun getCastingsAnime(
        @Path("id") id: Int,
    ): Response<CastingsResponse>


    @GET(ANIME_ID_CATEGORIES_KEY)
    suspend fun getCategoriesAnime(
        @Path("id") id: Int,
    ): Response<CategoriesResponse>
}