package com.example.demomvvm.di

import androidx.room.Room
import com.example.demomvvm.data.repository.CatRepository
import com.example.demomvvm.data.repository.CatRepositoryImpl
import com.example.demomvvm.data.source.CatDataSource
import com.example.demomvvm.data.source.local.CatLocalDataSource
import com.example.demomvvm.data.source.local.database.AppDatabase
import com.example.demomvvm.data.source.local.database.AppDatabase.Companion.DATABASE_NAME
import com.example.demomvvm.data.source.remote.CatRemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().breedDao() }
}

val repoCatModule = module {
    single<CatDataSource.Remote> { CatRemoteDataSource(get()) }
    single<CatDataSource.Local> { CatLocalDataSource(get()) }
    single<CatRepository> { CatRepositoryImpl(get(), get()) }
}
