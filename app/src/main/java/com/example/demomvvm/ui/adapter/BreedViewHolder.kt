package com.example.demomvvm.ui.adapter

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.BR
import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.databinding.ItemBreedBinding

class BreedViewHolder(
    private val binding: ItemBreedBinding,
    onClickItem: (Breed) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var itemBreed: Breed? = null

    init {
        binding.root.setOnClickListener {
            itemBreed?.let {
                onClickItem(it)
            }
        }
    }

    fun bind(breed: Breed) {
        itemBreed = breed
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            binding.textDescription.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
        binding.setVariable(BR.breed, breed)
        binding.executePendingBindings()
    }
}
