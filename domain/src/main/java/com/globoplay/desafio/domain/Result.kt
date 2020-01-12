package com.globoplay.desafio.domain

import androidx.room.Entity

@Entity(tableName = "movies")
data class Result (
    var popularity: Int ? = 0,
    var id: Int ? = 0,
    var video: Boolean = false,
    var vote_count: Int ? = 0,
    var vote_average: Int ? = 0,
    var title: String? = null,
    var release_date: String? = null,
    var original_language: String? = null,
    var original_title: String? = null,
    var genre_ids : List<GenreID>? = null,
    var backdrop_path: String? = null,
    var adult: Boolean = false,
    var overview: String? = null,
    var poster_path: String? = null
)