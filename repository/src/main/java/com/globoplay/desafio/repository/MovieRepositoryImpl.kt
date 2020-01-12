package com.globoplay.desafio.repository

import com.globoplay.desafio.remote.api.MoviesAPI
import com.globoplay.desafio.domain.MoviesResponse

class MovieRepositoryImpl(private val api: MoviesAPI) : MovieRepository {

    override suspend fun getMovies(): MoviesResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
