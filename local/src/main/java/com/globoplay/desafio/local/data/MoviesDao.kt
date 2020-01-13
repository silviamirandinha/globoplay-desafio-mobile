package com.globoplay.desafio.local.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.globoplay.desafio.domain.Result

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies")
    fun findAllMovies(): LiveData<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovies(movies: List<Result>)
}