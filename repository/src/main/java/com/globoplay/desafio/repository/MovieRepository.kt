package com.globoplay.desafio.repository

import androidx.lifecycle.LiveData
import com.globoplay.desafio.domain.Favorite
import com.globoplay.desafio.domain.Result

interface MovieRepository {
    fun getListMovies(): LiveData<List<Result>>
    suspend fun getMovies()
    fun getListFavoriteMovies(): LiveData<List<Result>>
    fun addFavoriteMovies(id: Favorite)
}
