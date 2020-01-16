package com.globoplay.desafio.repository

import androidx.lifecycle.LiveData
import com.globoplay.desafio.domain.Favorite
import com.globoplay.desafio.domain.Result
import com.globoplay.desafio.remote.api.MoviesAPI
import com.globoplay.desafio.local.data.MoviesDao

class MovieRepositoryImpl(private val api: MoviesAPI,  private val dao: MoviesDao) : MovieRepository {

    override fun getListMovies(): LiveData<List<Result>> {
        return dao.findAllMovies()
    }

    override fun addFavoriteMovies(id: Favorite){
        dao.addFavoriteMovie(id)
    }

    override fun removeFavoriteMovies(id: String){
        dao.removeFavoriteMovies(id)
    }

    override fun getListFavoriteMovies(): LiveData<List<Result>> {
        return dao.findAllFavoriteMovies()
    }

    override fun verifyFavoriteMovie(id: String): LiveData<Favorite> {
        return dao.verifyFavoriteMovie(id)
    }

    override suspend fun getMovies() {
        val movies = api.getMovies("3599df922b2707a3b9ef2f95f1bbd73b","pt-BR","popularity.desc")
        movies.results?.let { dao.addMovies(it) }
    }


}
