package com.globoplay.desafio.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_id")
class GenreID {
    @PrimaryKey
    val id: Int ? = 0
}