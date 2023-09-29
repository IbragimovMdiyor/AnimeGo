package com.example.animego.presentation.animeDeteils.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.animego.R
import com.example.animego.data.utils.extensions.showView
import com.example.animego.databinding.FragmentAnimeDeteilsBinding
import com.example.animego.presentation.base.BaseFragment
import com.example.animego.presentation.homeScreen.models.Anime
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimeDeteilsFragment :
    BaseFragment<FragmentAnimeDeteilsBinding, AnimeDeteilsViewModel>(FragmentAnimeDeteilsBinding::inflate),
    View.OnClickListener {

    override val viewModel: AnimeDeteilsViewModel by viewModel()

    override fun onReady(savedInstanceState: Bundle?) {}

    private val anime: Anime by lazy(LazyThreadSafetyMode.NONE) {
        AnimeDeteilsFragmentArgs.fromBundle(requireArguments()).anime
    }

    private var isFavorite = false
    private var isTypeAnime = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabOnClick()
        observeRecourses()
        showUi()
    }

    private fun fabOnClick() = requireBinding().apply {
        needScroll.post { needScroll.scrollTo(0, 2400) }
    }

    private fun observeRecourses() {
        viewModel.isFavorite.observe(viewLifecycleOwner) { checkingForFavorites(status = it) }
        viewModel.message.observe(viewLifecycleOwner) { showToast(message = it) }
        viewModel.setFavImageRecourse.observe(viewLifecycleOwner) { setFavImageRecourse(status = it) }
        bindUi(updateAnime = anime)

    }

    override fun onClick(v: View?) {}

    private fun showToast(message: String) =
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

    private fun setFavImageRecourse(status: Boolean) {
        isFavorite != status
        requireBinding().likeImg.setImageResource(if (status) R.drawable.like_icon else R.drawable.ic_unfavorite)
    }

    private fun checkingForFavorites(status: Boolean) {
        isFavorite = status
        requireBinding().likeImg.setImageResource(if (status) R.drawable.like_icon else R.drawable.ic_unfavorite)
    }

    private fun showUi() = requireBinding().apply { AllUi.showView() }


    @SuppressLint("SetTextI18n")
    private fun bindUi(updateAnime: Anime) {
        val anime = updateAnime.attributes!!
        val infoReleased = anime.createdAt?.substring(0, 4)
        requireBinding().apply {
            toolbar.title = anime.canonicalTitle ?: anime.titles?.enJp ?: anime.titles?.en
            typeTv.text = anime.showType
            overviewText.text = anime.description
            animeInfoRelesed.text = infoReleased
            animeDetailsStatus.text = anime.status
            val rating = anime.averageRating?.toDouble()
            ratingS.progress = rating?.toInt()!!

            if (anime.showType == "TV") {
                isTypeAnime = true
                typeTv.text = "${anime.showType} Series"

                Picasso.get().load(
                    anime.posterImage?.original ?: anime.coverImage?.original
                ).into(animeDetailsHeader)
                Picasso.get().load(
                    anime.posterImage?.original ?: anime.coverImage?.original
                ).into(animeDetailsCoverImage)
            }
        }
    }
}