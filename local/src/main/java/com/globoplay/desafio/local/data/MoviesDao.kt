package com.globoplay.desafio.local.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.globoplay.desafio.domain.GenreID
import com.globoplay.desafio.domain.Result

@Dao
interface MoviesDao {

    /*@Query("SELECT * FROM movies")
    fun findAllMovies(): LiveData<List<Result>>
*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovies(movies: List<Result>)

    @Query("SELECT * FROM movies")
    fun findAllMovies(): LiveData<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleResult(result: Result)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenreIds(genreIds: Result)

    @Transaction
    fun addMovie(result: Result) {
        insertGenreIds(result)
        insertSingleResult(result)
    }
}