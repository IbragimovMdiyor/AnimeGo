package com.example.animego.presentation.di

import com.example.animego.data.repositoryImpls.AnimeDetailsRepositoryImpl
import com.example.animego.data.repositoryImpls.HomeRepositoryImpl
import com.example.animego.data.repositoryImpls.SearchRepositoryImpl
import com.example.animego.domain.repositories.AnimeDetailsoRepository
import com.example.animego.domain.repositories.HomeRepository
import com.example.animego.domain.repositories.SearchRepository
import org.koin.dsl.module
import org.koin.dsl.single

val dataModule = module {

    single <HomeRepository>{
            HomeRepositoryImpl()
    }

    single<SearchRepository>{
        SearchRepositoryImpl()
    }
    single<AnimeDetailsoRepository> {
        AnimeDetailsRepositoryImpl()

    }
}