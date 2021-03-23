package com.example.demomvvm.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.demomvvm.data.model.Detail
import com.example.demomvvm.data.source.local.database.AppDatabase.Companion.DATABASE_VERSION
import com.example.demomvvm.data.source.local.database.AppDatabase.Companion.EXPORT_SCHEME
import com.example.demomvvm.data.source.local.database.dao.BreedDao
import com.example.demomvvm.utlis.TypeConverter

@Database(
    entities = [Detail::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao

    companion object {
        const val DATABASE_VERSION = 11
        const val DATABASE_NAME = "cat_database"
        const val EXPORT_SCHEME = false
    }
}
