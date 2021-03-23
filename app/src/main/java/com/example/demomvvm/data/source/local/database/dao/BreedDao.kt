package com.example.demomvvm.data.source.local.database.dao

import androidx.room.*
import com.example.demomvvm.data.model.Detail
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface BreedDao {
    @Query("SELECT * FROM breed")
    fun getFavorites(): Observable<List<Detail>>

    @Insert
    fun insertFavorites(breed: Detail): Completable

    @Delete
    fun deleteFavorites(breed: Detail): Completable

    @Query("SELECT * FROM breed WHERE id =:id")
    fun isFavorite(id: String): Single<List<Detail>>
}
