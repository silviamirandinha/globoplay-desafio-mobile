package com.globoplay.desafio.mirandinha

import android.app.Application
import com.globoplay.desafio.local.data.di.dataModule
import com.globoplay.desafio.mirandinha.di.favoriteModule
import com.globoplay.desafio.mirandinha.di.homeModule
import com.globoplay.desafio.remote.networkModule
import com.globoplay.desafio.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DesafioApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DesafioApplication)
            modules(listOf(homeModule, favoriteModule, networkModule, repositoryModule, dataModule))
        }
    }
}