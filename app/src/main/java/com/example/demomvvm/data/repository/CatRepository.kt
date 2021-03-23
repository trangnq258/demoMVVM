package com.example.demomvvm.data.repository

import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.data.model.Detail
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface CatRepository {
    fun getBreeds(): Observable<List<Breed>>
    fun getBreedDetail(id: String): Single<Detail>
    fun getFavorites(): Observable<List<Detail>>
    fun insertFavorites(breed: Detail): Completable
    fun deleteFavorites(breed: Detail): Completable
    fun isFavorite(id: String): Single<Boolean>
}
