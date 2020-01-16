package com.globoplay.desafio.mirandinha.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.globoplay.desafio.domain.Result
import com.globoplay.desafio.repository.MovieRepository

class FavoriteViewModel(private val repository: MovieRepository) : ViewModel() {

    val listFavoriteMovies: LiveData<List<Result>> = repository.getListFavoriteMovies()
}