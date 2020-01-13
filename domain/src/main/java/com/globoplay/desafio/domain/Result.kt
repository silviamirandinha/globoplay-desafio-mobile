package com.globoplay.desafio.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Result (
    val popularity: Int ? = 0,
    @PrimaryKey val id: Int ? = 0,
    val video: Boolean = false,
    val vote_count: Int ? = 0,
    val vote_average: Int ? = 0,
    val title: String? = null,
    val release_date: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val backdrop_path: String? = null,
    val adult: Boolean = false,
    val overview: String? = null,
    val poster_path: String? = null
)