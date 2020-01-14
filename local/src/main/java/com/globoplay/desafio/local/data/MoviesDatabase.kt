package com.globoplay.desafio.local.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.globoplay.desafio.domain.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}
