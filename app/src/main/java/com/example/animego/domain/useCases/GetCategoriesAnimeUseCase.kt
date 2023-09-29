package com.example.animego.domain.useCases

import com.example.animego.data.network.models.categories.CategoriesResponse
import com.example.animego.domain.repositories.AnimeDetailsoRepository
import retrofit2.Response

class GetCategoriesAnimeUseCase(private val repository: AnimeDetailsoRepository) {
    suspend fun execute(id: Int): Response<CategoriesResponse> =
        repository.getCategoriesAnime(id = id)
}