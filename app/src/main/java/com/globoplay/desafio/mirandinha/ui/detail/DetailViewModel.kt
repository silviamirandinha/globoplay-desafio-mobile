package com.globoplay.desafio.mirandinha.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.globoplay.desafio.domain.Favorite
import com.globoplay.desafio.repository.MovieRepository

class DetailViewModel(private val repository: MovieRepository) : ViewModel() {

    private val isFavorite: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            value = false
        }
    }

    fun addFavoriteMovie(id: Favorite){
      repository.addFavoriteMovies(id)
    }

    var favorite: LiveData<Favorite>? =null

    fun checkFavorite(id: String){
        favorite = repository.verifyFavoriteMovie(id)
    }



}
