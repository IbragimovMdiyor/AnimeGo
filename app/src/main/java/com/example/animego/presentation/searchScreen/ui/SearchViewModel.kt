package com.example.animego.presentation.searchScreen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.animego.domain.useCases.CreatePagerSearchUseCase
import com.example.animego.presentation.base.BaseViewModel
import com.example.animego.presentation.homeScreen.models.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn

class SearchViewModel (
    private val useCase: CreatePagerSearchUseCase
) : BaseViewModel() {


    private val _queryBy: MutableLiveData<String> = MutableLiveData<String>()

    init {
        _queryBy.value = ""
    }

    val searchFlow: Flow<PagingData<Anime>> by lazy(LazyThreadSafetyMode.NONE) {
        _queryBy.asFlow()
            .flatMapLatest {
                useCase.execute(query = _queryBy.value!!)
            }
            .cachedIn(viewModelScope)
            .flowOn(Dispatchers.IO)
    }

    fun startSearch(query: String) {
        _queryBy.value = query
    }

    fun goBack() = navigateBack()
    fun goAnimeInfoFragment(anime: Anime) =
        navigate(SearchFragmentDirections.actionSearchScreenToAnimeDeteilsFragment(anime = anime))
}