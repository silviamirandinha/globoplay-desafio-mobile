package com.globoplay.desafio.local.data.di

import androidx.room.Room
import com.globoplay.desafio.local.data.MoviesDatabase
import org.koin.dsl.module

val dataModule = module {
    single { get<MoviesDatabase>().moviesDao }
    single {
            Room.databaseBuilder(get(), MoviesDatabase::class.java, "movie.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries().build() }
}