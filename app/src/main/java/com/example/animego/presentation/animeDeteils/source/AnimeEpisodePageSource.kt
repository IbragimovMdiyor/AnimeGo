package com.example.animego.presentation.animeDeteils.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animego.data.network.models.episodes.Episodes
import com.example.animego.data.utils.utils.Utils.MAX_PAGE_SIZE
import com.example.animego.domain.repositories.AnimeDetailsoRepository
import retrofit2.HttpException

class AnimeEpisodePageSource(
    private val id: Int,
    private val repository: AnimeDetailsoRepository,
) : PagingSource<Int, Episodes>() {
    override fun getRefreshKey(state: PagingState<Int, Episodes>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episodes> {
        val page: Int = params.key?.plus(20) ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)
        return try {
            val response = repository.getEpisodesAnime(id = id, pageSize = pageSize, page = page)
            if (response.isSuccessful) {
                val episodes = checkNotNull(response.body()?.episodes)
                val nextKey = if (episodes.size < pageSize) null else page + 1
                val prevKey = if (page == 1) null else page - 1
                LoadResult.Page(episodes, prevKey, nextKey)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}