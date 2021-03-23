package com.example.demomvvm.data.model

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "breed")
data class Detail(
    @PrimaryKey
    @SerializedName("id")
    var id: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("breeds")
    var breeds: List<Breed>
) {

    constructor(id: String, url: String) : this(
        id,
        url,
        breeds = mutableListOf()
    )

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Detail>() {
            override fun areItemsTheSame(oldItem: Detail, newItem: Detail) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Detail, newItem: Detail) =
                oldItem == newItem
        }
    }
}
