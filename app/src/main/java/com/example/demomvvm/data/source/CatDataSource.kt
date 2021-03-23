package com.example.demomvvm.data.source

import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.data.model.Detail
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface CatDataSource {
    interface Remote {
        fun getBreeds(): Observable<List<Breed>>
        fun getBreedDetail(id: String): Single<Detail>
    }

    interface Local {
        fun getFavorites(): Observable<List<Detail>>
        fun insertFavorites(breed: Detail): Completable
        fun deleteFavorites(breed: Detail): Completable
        fun isFavorite(id: String): Single<Boolean>
    }
}
