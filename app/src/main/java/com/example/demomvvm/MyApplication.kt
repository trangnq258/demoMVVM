package com.example.demomvvm

import android.app.Application
import com.example.demomvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    netWorkModule,
                    apiModule,
                    repoCatModule,
                    viewModelModule,
                    dbModule
                )
            )
        }
    }
}
