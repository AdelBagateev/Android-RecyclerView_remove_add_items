package com.example.list_items.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.list_items.databinding.AdCasinoBinding

class AdItem(
    private val binding: AdCasinoBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): AdItem = AdItem(
            binding = AdCasinoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}