package com.globoplay.desafio.domain

import androidx.room.TypeConverter
import com.google.gson.Gson

class GenreConverter {

    @TypeConverter
    fun listToJson(value: List<GenreID>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<GenreID>? {

        val objects = Gson().fromJson(value, Array<GenreID>::class.java) as Array<GenreID>
        val list = objects.toList()
        return list
    }
}