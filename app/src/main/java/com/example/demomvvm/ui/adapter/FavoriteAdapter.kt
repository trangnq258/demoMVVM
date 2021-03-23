package com.example.demomvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.demomvvm.R
import com.example.demomvvm.data.model.Detail

class FavoriteAdapter(
    private val onItemClick: (Detail) -> Unit
) : ListAdapter<Detail, FavoriteViewHolder>(Detail.diffUtil), UpdateDataAdapter<Detail> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_favorite, parent, false
            ),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(data: List<Detail>?) {
        submitList(data)
    }
}
