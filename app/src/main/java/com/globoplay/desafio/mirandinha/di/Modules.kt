package com.globoplay.desafio.mirandinha.di

import com.globoplay.desafio.mirandinha.ui.favorite.FavoriteFragment
import com.globoplay.desafio.mirandinha.ui.favorite.FavoriteViewModel
import com.globoplay.desafio.mirandinha.ui.home.HomeFragment
import com.globoplay.desafio.mirandinha.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val homeModule = module {
    //TODO: REPOSITORY AND API
    viewModel { HomeViewModel() }
    factory { HomeFragment() }
}

val favoriteModule = module {
    //TODO: REPOSITORY AND API
    viewModel { FavoriteViewModel() }
    factory { FavoriteFragment() }
}

