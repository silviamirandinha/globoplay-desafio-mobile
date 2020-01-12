package com.globoplay.desafio.remote


import com.globoplay.desafio.remote.api.MoviesAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { providerApi(get()) }
    single { provideOkHttpClient() }
    single { providerRetrofit(get()) }
}

fun providerRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.HOST)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .build()
}

fun providerApi(retrofit: Retrofit): MoviesAPI = retrofit.create(MoviesAPI::class.java)

