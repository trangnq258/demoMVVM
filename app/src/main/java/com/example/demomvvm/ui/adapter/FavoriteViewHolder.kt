package com.example.demomvvm.ui.adapter

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.BR
import com.example.demomvvm.data.model.Detail
import com.example.demomvvm.databinding.ItemFavoriteBinding

class FavoriteViewHolder(
    private val binding: ItemFavoriteBinding,
    onClickItem: (Detail) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var itemBreed: Detail? = null

    init {
        binding.root.setOnClickListener {
            itemBreed?.let {
                onClickItem(it)
            }
        }
    }

    fun bind(breed: Detail) {
        itemBreed = breed
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            binding.textDescription.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
        binding.setVariable(BR.breedResponse, breed)
        binding.executePendingBindings()
    }
}
