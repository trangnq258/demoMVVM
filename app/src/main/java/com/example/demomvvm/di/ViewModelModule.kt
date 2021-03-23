package com.example.demomvvm.di

import com.example.demomvvm.ui.detail.DetailViewModel
import com.example.demomvvm.ui.favorite.FavoriteViewModel
import com.example.demomvvm.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}
