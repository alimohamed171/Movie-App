package com.example.movieapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.models.MovieModel
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(list :List<MovieModel>):Completable
    @Query("select * From MOVIE_TABLE")
    fun getMovies():Single<List<MovieModel>>
}