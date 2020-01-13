package com.globoplay.desafio.local.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.globoplay.desafio.domain.GenreConverter
import com.globoplay.desafio.domain.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
@TypeConverters(GenreConverter::class)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}
