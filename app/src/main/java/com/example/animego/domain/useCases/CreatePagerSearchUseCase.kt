package com.example.animego.domain.useCases

import com.example.animego.domain.repositories.SearchRepository

class CreatePagerSearchUseCase(private val repository: SearchRepository) {
    fun execute(query: String) = repository.createPagerSearch(query = query)
}
