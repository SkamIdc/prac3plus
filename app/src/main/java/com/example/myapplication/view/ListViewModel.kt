package com.example.myapplication.view

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.data.MovieDatabase
import com.example.myapplication.model.Movie

class ListViewModel(
    private val repository: MovieDatabase,
    private val navigation: NavHostController,
    private var movies: List<Movie> = emptyList()
) : ViewModel() {

    init {
        movies = loadMovies()
    }

    fun loadMovies(): List<Movie> {
        return movies.ifEmpty { repository.getList() }
    }

    fun onItemClicked(id: Int) {
        navigation.navigate("movieDetail/$id")
    }
}