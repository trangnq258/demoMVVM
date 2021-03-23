package com.example.demomvvm.data.source.remote

import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.data.model.Detail
import com.example.demomvvm.data.source.CatDataSource
import com.example.demomvvm.data.source.remote.utlis.APIService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class CatRemoteDataSource(
    private val apiService: APIService
) : CatDataSource.Remote {

    override fun getBreeds(): Observable<List<Breed>> = apiService.getBreeds()
    override fun getBreedDetail(id: String): Single<Detail> = apiService.getBreedDetail(id)
}
