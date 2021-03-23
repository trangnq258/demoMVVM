package com.example.demomvvm.data.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    var id: String,
    @SerializedName("width")
    var width: String,
    @SerializedName("height")
    var height: String,
    @SerializedName("url")
    var url: String
)
