package com.example.demomvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.demomvvm.R
import com.example.demomvvm.data.model.Breed

class BreedAdapter(
    private val onItemClick: (Breed) -> Unit
) : ListAdapter<Breed, BreedViewHolder>(Breed.diffUtil), UpdateDataAdapter<Breed> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_breed, parent, false
            ),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(data: List<Breed>?) {
        submitList(data)
    }
}
