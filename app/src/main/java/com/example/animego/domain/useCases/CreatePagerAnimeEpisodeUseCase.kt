package com.example.animego.domain.useCases

import androidx.paging.PagingData
import com.example.animego.data.network.models.episodes.Episodes
import com.example.animego.domain.repositories.AnimeDetailsoRepository
import kotlinx.coroutines.flow.Flow

class CreatePagerAnimeEpisodeUseCase(private val repository: AnimeDetailsoRepository) {
    fun execute(id: Int): Flow<PagingData<Episodes>> = repository.createPagerAnimeEpisode(id = id)
}