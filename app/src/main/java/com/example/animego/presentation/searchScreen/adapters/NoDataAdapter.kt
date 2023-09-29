package com.example.animego.presentation.searchScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animego.R
import com.example.animego.databinding.ItemNothingFoundBinding

class NoDataAdapter : RecyclerView.Adapter<NoDataAdapter.ErrorViewHolder>() {

    inner class ErrorViewHolder(binding: ItemNothingFoundBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ErrorViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_nothing_found, parent, false)
        val binding = ItemNothingFoundBinding.bind(layoutInflater)
        return ErrorViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ErrorViewHolder, position: Int) {}

    override fun getItemCount(): Int = 1
}