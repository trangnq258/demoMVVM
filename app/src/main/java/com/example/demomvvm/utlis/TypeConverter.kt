package com.example.demomvvm.utlis

import androidx.room.TypeConverter
import com.example.demomvvm.data.model.Breed
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

class TypeConverter : Serializable {
    @TypeConverter
    fun fromGroupTaskMemberList(value: List<Breed>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Breed>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberList(value: String): List<Breed> {
        val gson = Gson()
        val type = object : TypeToken<List<Breed>>() {}.type
        return gson.fromJson(value, type)
    }
}
