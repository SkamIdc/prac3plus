package com.example.myapplication.data

class MovieDatabase {
    fun getList() = MoviesData.movies
    fun getMovie(id: Int) = MoviesData.movies.find { it.id == id }
}