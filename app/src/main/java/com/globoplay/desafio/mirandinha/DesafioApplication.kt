package com.globoplay.desafio.mirandinha

import android.app.Application
import com.globoplay.desafio.local.data.di.localModule
import com.globoplay.desafio.mirandinha.di.*
import com.globoplay.desafio.remote.apiModule
import com.globoplay.desafio.remote.networkModule
import com.globoplay.desafio.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DesafioApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DesafioApplication)
            modules(listOf(apiModule, networkModule, localModule, repositoryModule, viewModelModule))
        }
    }
}