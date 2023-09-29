package com.example.animego.presentation.di

import com.example.animego.presentation.animeDeteils.ui.AnimeDeteilsViewModel
import com.example.animego.presentation.homeScreen.ui.HomeViewModel
import com.example.animego.presentation.searchScreen.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {


    viewModel {
        HomeViewModel(
            useCase = get()
        )
    }

    viewModel {
        SearchViewModel(
            useCase = get()
        )
    }

    viewModel {
        AnimeDeteilsViewModel(
            get(),
            get(),
            get(),
        )
    }

}





