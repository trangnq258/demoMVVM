package com.example.demomvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.data.model.Detail
import com.example.demomvvm.data.repository.CatRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailViewModel(
    private val repository: CatRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _detail = MutableLiveData<Detail>()
    val detail: LiveData<Detail> get() = _detail

    private val _breed = MutableLiveData<Breed>()
    val breed: LiveData<Breed> get() = _breed

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun loadDetail(id: String) {
        getBreedDetail(id)
        checkFavorite(id)
    }

    private fun getBreedDetail(id: String) {
        repository.getBreedDetail(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _detail.value = it
                _breed.value = it.breeds[0]
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun checkFavorite(id: String) {
        repository.isFavorite(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isFavorite.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    fun updateFavorite() {
        detail.value?.let { it ->
            if (isFavorite.value == true) {
                repository.deleteFavorites(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _isFavorite.value = false
                    }, {
                        _error.value = it.message.toString()
                    })
                    .addTo(disposables)
            } else {
                repository.insertFavorites(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _isFavorite.value = true
                    }, {
                        _error.value = it.message.toString()
                    })
                    .addTo(disposables)
            }
        }
    }
}
