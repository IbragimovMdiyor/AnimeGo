package com.example.animego.presentation.di

import com.example.animego.domain.useCases.*
import org.koin.dsl.module

val domainModule = module {

    factory {
        CreatePagerAnimeUseCase(
            repository = get ()
        )
    }

    factory {
        CreatePagerSearchUseCase(
            repository = get()
        )
    }

    factory {
        CreatePagerAnimeEpisodeUseCase(
            repository = get()
        )
    }

    factory {
        GetCategoriesAnimeUseCase(
            repository = get()
        )
    }

    factory {
        GetCastingsAnimeUseCase(
            repository = get()
        )
    }
}