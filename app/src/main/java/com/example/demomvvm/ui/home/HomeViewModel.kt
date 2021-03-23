package com.example.demomvvm.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.data.repository.CatRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(
    private val repository: CatRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _breed = MutableLiveData<List<Breed>>()
    val breed: LiveData<List<Breed>> get() = _breed

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        getData()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    private fun getData() {
        repository.getBreeds()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _breed.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
