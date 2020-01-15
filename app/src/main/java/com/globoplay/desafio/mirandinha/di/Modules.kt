package com.globoplay.desafio.mirandinha.di

import com.globoplay.desafio.mirandinha.ui.detail.DetailViewModel
import com.globoplay.desafio.mirandinha.ui.favorite.FavoriteViewModel
import com.globoplay.desafio.mirandinha.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel() }
    viewModel { DetailViewModel(get()) }
}