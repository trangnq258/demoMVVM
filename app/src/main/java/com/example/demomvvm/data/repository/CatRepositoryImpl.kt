package com.example.demomvvm.data.repository

import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.data.model.Detail
import com.example.demomvvm.data.source.CatDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class CatRepositoryImpl(
    private val remote: CatDataSource.Remote,
    private val local: CatDataSource.Local
) : CatRepository {

    override fun getBreeds(): Observable<List<Breed>> = remote.getBreeds()

    override fun getBreedDetail(id: String): Single<Detail> = remote.getBreedDetail(id)

    override fun getFavorites(): Observable<List<Detail>> = local.getFavorites()

    override fun insertFavorites(breed: Detail): Completable = local.insertFavorites(breed)

    override fun deleteFavorites(breed: Detail): Completable = local.deleteFavorites(breed)

    override fun isFavorite(id: String): Single<Boolean> = local.isFavorite(id)
}
