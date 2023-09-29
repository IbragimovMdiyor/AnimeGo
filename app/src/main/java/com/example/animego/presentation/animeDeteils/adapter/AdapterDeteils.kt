package com.example.animego.presentation.animeDeteils.adapter

import androidx.appcompat.app.AppCompatActivity
import com.example.animego.presentation.homeScreen.models.Anime

class AdapterDeteils: AppCompatActivity() {




    interface RecyclerOnClickListener {
        fun onItemclick (anime: Anime)
    }


}

