package com.example.demomvvm.utlis

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.demomvvm.R

fun ImageView.loadImage(image: String?) {
    Glide.with(context).load(image)
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_place_holder)
        .into(this)
}

fun ImageView.loadImageCircle(image: String?) {
    Glide.with(context).load(image)
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_place_holder)
        .circleCrop()
        .into(this)
}
