package com.example.demomvvm.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.demomvvm.utlis.loadImage
import com.example.demomvvm.utlis.loadImageCircle

@BindingAdapter("image", "cropStatus")
fun loadUrlImageCircle(imageView: ImageView, urlImage: String?, cropStatus: Boolean) {
    if (cropStatus) {
        imageView.loadImageCircle(urlImage)
    } else {
        imageView.loadImage(urlImage)
    }
}
