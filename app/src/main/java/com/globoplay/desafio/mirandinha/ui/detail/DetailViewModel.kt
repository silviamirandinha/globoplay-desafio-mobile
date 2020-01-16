package com.globoplay.desafio.mirandinha.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.globoplay.desafio.domain.Favorite
import com.globoplay.desafio.repository.MovieRepository

class DetailViewModel(private val repository: MovieRepository) : ViewModel() {

    fun removeFavorite(id: String) {
        repository.removeFavoriteMovies(id)
    }

    fun addFavorite(favorite: Favorite) {
        repository.addFavoriteMovies(favorite)
    }

    var favorite: LiveData<Favorite>? =null

    fun checkFavorite(id: String){
        favorite = repository.verifyFavoriteMovie(id)
    }



}
