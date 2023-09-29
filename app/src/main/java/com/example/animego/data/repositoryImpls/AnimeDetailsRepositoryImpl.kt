package com.example.animego.data.repositoryImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.animego.data.network.models.castings.CastingsResponse
import com.example.animego.data.network.models.categories.CategoriesResponse
import com.example.animego.data.network.models.episodes.Episodes
import com.example.animego.data.network.models.episodes.EpisodesResponse
import com.example.animego.data.utils.utils.RetrofitInstance
import com.example.animego.domain.repositories.AnimeDetailsoRepository
import com.example.animego.presentation.animeDeteils.source.AnimeEpisodePageSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class AnimeDetailsRepositoryImpl(
//    private val api: AnimeApi,
) : AnimeDetailsoRepository {
    val api = RetrofitInstance.api
    override suspend fun getEpisodesAnime(
        id: Int,
        page: Int,
        pageSize: Int
    ): Response<EpisodesResponse> {
        return api.getEpisodesAnime(id = id, pageSize = pageSize, page = page)
    }

    override suspend fun getCastingsAnime(id: Int): Response<CastingsResponse> =
        api.getCastingsAnime(id = id)

    override suspend fun getCategoriesAnime(id: Int): Response<CategoriesResponse> =
        api.getCategoriesAnime(id = id)

    override fun createPagerAnimeEpisode(id: Int): Flow<PagingData<Episodes>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory =
        {
            AnimeEpisodePageSource(repository = this, id = id)
        }
    ).flow
}