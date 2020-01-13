package com.globoplay.desafio.repository

import androidx.lifecycle.LiveData
import com.globoplay.desafio.domain.Result
import com.globoplay.desafio.remote.api.MoviesAPI
import com.globoplay.desafio.local.data.MoviesDao

class MovieRepositoryImpl(private val api: MoviesAPI,  private val dao: MoviesDao) : MovieRepository {

    override fun getListMovies(): LiveData<List<Result>> {
        return dao.findAllMovies()
    }

    override suspend fun getMovies() {
        val movies = api.getMovies("3599df922b2707a3b9ef2f95f1bbd73b","pt-BR","popularity.desc")
        movies.results?.let { dao.addMovies(it) }
    }


}
