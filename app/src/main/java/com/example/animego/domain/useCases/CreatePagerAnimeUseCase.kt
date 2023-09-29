package com.example.animego.domain.useCases

import androidx.paging.PagingData
import com.example.animego.domain.repositories.HomeRepository
import com.example.animego.presentation.homeScreen.models.Anime
import kotlinx.coroutines.flow.Flow

class CreatePagerAnimeUseCase(private val repository: HomeRepository) {
    fun execute(): Flow<PagingData<Anime>> = repository.createPagerAnime()
}