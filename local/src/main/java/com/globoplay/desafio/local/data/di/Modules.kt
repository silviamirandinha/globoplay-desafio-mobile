package com.globoplay.desafio.local.data.di

import android.app.Application
import androidx.room.Room
import com.globoplay.desafio.local.data.MoviesDao
import com.globoplay.desafio.local.data.MoviesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

    fun provideDatabase(application: Application): MoviesDatabase {
        return Room.databaseBuilder(application, MoviesDatabase::class.java, "movie.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: MoviesDatabase): MoviesDao {
        return database.moviesDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}