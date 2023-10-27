package com.example.movieapp.models

data class GenreModel(
    val genres: List<Genre>
)

data class Genre(
    val id: Int,
    val name: String
)