package com.example.demomvvm.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("origin")
    var origin: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("life_span")
    var lifeSpan: String,
    @SerializedName("adaptability")
    var adaptability: Int,
    @SerializedName("affection_level")
    var affectionLevel: Int,
    @SerializedName("child_friendly")
    var childFriendly: Int,
    @SerializedName("dog_friendly")
    var dogFriendly: Int,
    @SerializedName("energy_level")
    var energyLevel: Int,
    @SerializedName("grooming")
    var grooming: Int,
    @SerializedName("health_issues")
    var healthIssues: Int,
    @SerializedName("intelligence")
    var intelligence: Int,
    @SerializedName("shedding_level")
    var sheddingLevel: Int,
    @SerializedName("social_needs")
    var socialNeeds: Int,
    @SerializedName("stranger_friendly")
    var strangerFriendly: Int,
    @SerializedName("vocalisation")
    var vocalisation: Int,
    @SerializedName("wikipedia_url")
    var wikipediaUrl: String,
    @SerializedName("reference_image_id")
    var referenceImageId: String,
    @SerializedName("image")
    var image: Image
) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Breed>() {
            override fun areItemsTheSame(oldItem: Breed, newItem: Breed) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Breed, newItem: Breed) = oldItem == newItem
        }
    }
}
