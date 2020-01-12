package com.globoplay.desafio.remote.domain

class MoviesResponse {
    var page: Int ? = 0
    var total_results: Int ? = 0
    var total_pages: Int ? = 0
    var results : List<Result>? = null
}