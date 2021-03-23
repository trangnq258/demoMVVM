package com.example.demomvvm.di

import com.example.demomvvm.data.source.remote.utlis.APIService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(APIService::class.java) }
}
