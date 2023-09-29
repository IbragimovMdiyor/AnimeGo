package com.example.animego.data.repositoryImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.animego.data.network.models.anime.AnimeResponse
import com.example.animego.data.utils.utils.RetrofitInstance
import com.example.animego.domain.repositories.SearchRepository
import com.example.animego.presentation.homeScreen.models.Anime
import com.example.animego.presentation.searchScreen.source.SearchPageSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response

class SearchRepositoryImpl(
    //    private val api: AnimeApi,
) : SearchRepository {
    val api = RetrofitInstance.api
    override suspend fun searchAnime(
        page: Int,
        pageSize: Int,
        query: String
    ): Response<AnimeResponse> =
        withContext(Dispatchers.IO) {
            api.searchAnime(page = page, pageSize = pageSize, query = query)
        }

    override fun createPagerSearch(query: String): Flow<PagingData<Anime>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            SearchPageSource(this, query = query)
        }
    ).flow
}