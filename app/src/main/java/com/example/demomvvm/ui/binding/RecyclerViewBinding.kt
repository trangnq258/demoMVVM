package com.example.demomvvm.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.ui.adapter.UpdateDataAdapter

@BindingAdapter("data")
fun <T> setDataRecyclerView(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as UpdateDataAdapter<T>).setData(data)
}
