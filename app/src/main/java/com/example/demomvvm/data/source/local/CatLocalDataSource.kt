package com.example.demomvvm.data.source.local

import com.example.demomvvm.data.model.Detail
import com.example.demomvvm.data.source.CatDataSource
import com.example.demomvvm.data.source.local.database.dao.BreedDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class CatLocalDataSource(
    private val breedDao: BreedDao
) : CatDataSource.Local {

    override fun getFavorites(): Observable<List<Detail>> = breedDao.getFavorites()

    override fun insertFavorites(breed: Detail): Completable = breedDao.insertFavorites(breed)

    override fun deleteFavorites(breed: Detail): Completable = breedDao.deleteFavorites(breed)

    override fun isFavorite(id: String): Single<Boolean> =
        breedDao.isFavorite(id).map { it.isNotEmpty() }
}
