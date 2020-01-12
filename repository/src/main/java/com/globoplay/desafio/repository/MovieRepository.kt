package com.globoplay.desafio.repository

import androidx.lifecycle.MutableLiveData
import com.globoplay.desafio.domain.Result

interface MovieRepository {
    fun getListMovies(): MutableLiveData<List<Result>>
    suspend fun getMovies()
}
