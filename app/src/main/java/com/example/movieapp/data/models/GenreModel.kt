package com.example.movieapp.data.models

data class GenreModel(
    val genres: List<Genre>
)

data class Genre(
    val id: Int,
    val name: String
)