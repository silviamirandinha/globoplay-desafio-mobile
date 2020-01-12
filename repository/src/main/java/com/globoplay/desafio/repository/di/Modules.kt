package com.globoplay.desafio.repository.di

import com.globoplay.desafio.repository.MovieRepository
import com.globoplay.desafio.repository.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}