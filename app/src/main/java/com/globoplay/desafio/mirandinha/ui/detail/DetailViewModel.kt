package com.globoplay.desafio.mirandinha.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.globoplay.desafio.domain.Result
import com.globoplay.desafio.repository.MovieRepository

class DetailViewModel(private val repository: MovieRepository) : ViewModel() {

    val listMovies: LiveData<List<Result>> = repository.getListMovies()

}
