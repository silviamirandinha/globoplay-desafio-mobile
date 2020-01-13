package com.globoplay.desafio.repository

import androidx.lifecycle.LiveData
import com.globoplay.desafio.domain.Result

interface MovieRepository {
    fun getListMovies(): LiveData<List<Result>>
    suspend fun getMovies()
}
