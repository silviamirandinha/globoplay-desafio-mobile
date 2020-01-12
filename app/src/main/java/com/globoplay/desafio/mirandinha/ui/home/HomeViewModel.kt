package com.globoplay.desafio.mirandinha.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globoplay.desafio.mirandinha.util.RequestStatus
import com.globoplay.desafio.remote.api.MoviesAPI
import com.globoplay.desafio.repository.MovieRepository
import kotlinx.coroutines.launch
import com.globoplay.desafio.domain.Result

class HomeViewModel(private val repository: MovieRepository, val api: MoviesAPI) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _requestStatus = MutableLiveData<RequestStatus>()
    val requestStatus: MutableLiveData<RequestStatus>
        get() = _requestStatus

    val listMovies: MutableLiveData<List<Result>> = repository.getListMovies()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _requestStatus.postValue(RequestStatus.LOADING)
                repository.getMovies()
                _requestStatus.postValue(RequestStatus.LOADED)
            } catch (e: Exception) {
                _requestStatus.postValue(RequestStatus.error(e.message))
            }
        }
    }
}
