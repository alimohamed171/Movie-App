package com.example.movieapp.data.network

import com.example.movieapp.data.models.GenreModel
import com.example.movieapp.data.models.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {

    @GET("discover/movie")
    fun getMovie(@Query("api_key")
                 apiKey:String ="2ef3c1de058e21d31b231983b8a7dfb4")
    :Call<MovieModel>
    @GET("genre/movie/list")
    fun getGenre(@Query("api_key")
                 apiKey:String ="2ef3c1de058e21d31b231983b8a7dfb4")
            :Call<GenreModel>
}