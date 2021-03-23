package com.example.demomvvm.data.source.remote.utlis

import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.data.model.Detail
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("breeds")
    fun getBreeds(): Observable<List<Breed>>

    @GET("images/{image_id}")
    fun getBreedDetail(@Path("image_id") id: String): Single<Detail>
}
