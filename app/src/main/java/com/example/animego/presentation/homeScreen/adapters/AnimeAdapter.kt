package com.example.animego.presentation.homeScreen.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animego.R
import com.example.animego.data.utils.click_listener.AnimeOnClickListener
import com.example.animego.databinding.ItemHomeScreenBinding
import com.example.animego.presentation.homeScreen.models.Anime
import com.example.animego.presentation.homeScreen.ui.HomeFragment
import com.squareup.picasso.Picasso

class AnimeAdapter(private val actionListener: AnimeOnClickListener) :
    PagingDataAdapter<Anime, AnimeAdapter.AnimeViewHolder>(AnimeDiffItemCallBack) {

    inner class AnimeViewHolder(private val binding: ItemHomeScreenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(anime: Anime) {
            binding.apply {
                animeTitle.text =
                    anime.attributes?.canonicalTitle ?: anime.attributes?.titles?.en

                val infoReleased = anime.attributes?.startDate?.substring(0, 4)
                animeRelesedId.text = "Released: $infoReleased"

                Picasso.get()
                    .load(anime.attributes?.posterImage?.small)
                    .placeholder(R.drawable.manga)
                    .resize(200, 200)
                    .into(animeImage)
            }
            itemView.setOnClickListener {
                actionListener.showAnimeInfo(anime = anime)
            }
        }
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(anime = it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_screen, parent, false)
        val binding = ItemHomeScreenBinding.bind(inflater)
        return AnimeViewHolder(binding)
    }
}

private object AnimeDiffItemCallBack : DiffUtil.ItemCallback<Anime>() {

    override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean =
        oldItem.animeId == newItem.animeId && oldItem.type == newItem.type

}