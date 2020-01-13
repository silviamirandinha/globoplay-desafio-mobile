package com.globoplay.desafio.repository.di

import com.globoplay.desafio.local.data.MoviesDao
import com.globoplay.desafio.remote.api.MoviesAPI
import com.globoplay.desafio.repository.MovieRepository
import com.globoplay.desafio.repository.MovieRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    fun provideMovieRepository(api: MoviesAPI, dao: MoviesDao): MovieRepository {
        return MovieRepositoryImpl(api, dao)
    }

    single { provideMovieRepository(get(), get()) }
}