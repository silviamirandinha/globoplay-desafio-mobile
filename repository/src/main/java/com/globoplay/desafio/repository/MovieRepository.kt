package com.globoplay.desafio.repository

import com.globoplay.desafio.domain.MoviesResponse

interface MovieRepository {
    suspend fun getMovies(): MoviesResponse
}
