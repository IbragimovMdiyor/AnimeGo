package com.example.animego.presentation.homeScreen.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.animego.data.utils.click_listener.AnimeOnClickListener
import com.example.animego.data.utils.extensions.showToast
import com.example.animego.data.utils.loader.LoaderStateAdapter
import com.example.animego.databinding.FragmentHomeBinding
import com.example.animego.presentation.base.BaseFragment
import com.example.animego.presentation.homeScreen.adapters.AnimeAdapter
import com.example.animego.presentation.homeScreen.models.Anime
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate),
    AnimeOnClickListener {

    override val viewModel: HomeViewModel by viewModel()

    private val adapter: AnimeAdapter by lazy(LazyThreadSafetyMode.NONE) {
        AnimeAdapter(actionListener = this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingAdapterAttributes()
        observeAnime()
    }

    private fun observeAnime() = lifecycleScope.launch {
        viewModel.animeSeasonFlow.collectLatest(adapter::submitData)

        repeatOnLifecycle(state = Lifecycle.State.CREATED) {
            if (getCurrentTheme()) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun getCurrentTheme(): Boolean {
        return PreferenceManager
            .getDefaultSharedPreferences(requireContext())
            .getBoolean("theme", false)
    }

    private fun settingAdapterAttributes() = requireBinding().apply {
        homeAnimeRv.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderStateAdapter(),
            footer = LoaderStateAdapter()
        )
        adapter.addLoadStateListener { state ->
            if (state.refresh !is LoadState.Error) return@addLoadStateListener
            requireContext().showToast((state.refresh as LoadState.Error).error.message ?: "")
        }
    }

    override fun showAnimeInfo(anime: Anime) {
        viewModel.goAnimeInfoFragment(anime)
    }

    override fun onReady(savedInstanceState: Bundle?) = Unit
}