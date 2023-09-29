package com.example.animego.domain.useCases

import com.example.animego.data.network.models.castings.CastingsResponse
import com.example.animego.domain.repositories.AnimeDetailsoRepository
import retrofit2.Response

class GetCastingsAnimeUseCase(private val repository: AnimeDetailsoRepository) {
    suspend fun execute(id: Int): Response<CastingsResponse> = repository.getCastingsAnime(id = id)

}