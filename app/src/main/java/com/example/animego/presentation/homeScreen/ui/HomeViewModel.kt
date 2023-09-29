package com.example.animego.presentation.homeScreen.ui

import androidx.paging.PagingData
import com.example.animego.domain.useCases.CreatePagerAnimeUseCase
import com.example.animego.presentation.base.BaseViewModel
import com.example.animego.presentation.homeScreen.models.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class HomeViewModel(
    private val useCase: CreatePagerAnimeUseCase
) : BaseViewModel() {

    val animeSeasonFlow: Flow<PagingData<Anime>> by lazy(LazyThreadSafetyMode.NONE) {
        useCase.execute().flowOn(Dispatchers.IO)
    }

    fun goAnimeInfoFragment(anime: Anime) =
        navigate(HomeFragmentDirections.actionHomeScreenToAnimeDeteilsFragment(anime = anime))
}








