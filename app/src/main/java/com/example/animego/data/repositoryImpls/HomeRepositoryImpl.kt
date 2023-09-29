package com.example.animego.data.repositoryImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.animego.data.network.models.anime.AnimeResponse
import com.example.animego.data.utils.utils.RetrofitInstance
import com.example.animego.domain.repositories.HomeRepository
import com.example.animego.presentation.homeScreen.models.Anime
import com.example.animego.presentation.homeScreen.source.AnimePageSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response

class HomeRepositoryImpl(
//    private val api: AnimeApi,
) : HomeRepository {
            val api = RetrofitInstance.api
    override suspend fun getAllAnime(pageSize: Int, page: Int):Response <AnimeResponse> =
        withContext(Dispatchers.IO) {
            api.getAllAnime(page = page, pageSize = pageSize)
        }


    override fun createPagerAnime(): Flow<PagingData<Anime>> = Pager(
        config = PagingConfig(
            pageSize = 18,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            AnimePageSource(repository = this)
        }
    ).flow
}