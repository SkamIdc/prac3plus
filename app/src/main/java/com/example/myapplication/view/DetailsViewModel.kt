package com.example.myapplication.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.data.MovieDatabase
import com.example.myapplication.model.Movie

class DetailsViewModel(
    private val repository: MovieDatabase,
    private val navigation: NavHostController,
    private val id: Int
) : ViewModel() {

    val uiState = mutableStateOf<MovieDetailsUI?>(null)

    init {
        repository.getMovie(id)?.let {
            uiState.value = MovieDetailsUI.from(it)
        }
    }

    fun back() {
        navigation.popBackStack()
    }
}

data class MovieDetailsUI(
    val posterURL: String,
    val name: String,
    val description: String,
    val details: List<Pair<String, String>>,
    val persons: List<PersonUI>
) {
    companion object {
        fun from(movie: Movie): MovieDetailsUI {
            return MovieDetailsUI(
                posterURL = movie.posterURL,
                name = movie.name,
                description = movie.description,
                details = listOf(
                    "Кинопоиск" to movie.rating.kp.toString(),
                    "IMDB" to movie.rating.imdb.toString(),
                    "Жанры" to movie.genres.joinToString(", "),
                    "Страна" to movie.countries.joinToString(", "),
                    "Продолжительность" to "${movie.movieLength} минут",
                    "Возрастные ограничения" to "${movie.ageRating}+",
                    "Год выхода" to movie.year.toString(),
                    ),
                persons = movie.persons.map { PersonUI(it.name, it.character, it.photoURL) }
            )
        }
    }
}

data class PersonUI(
    val name: String,
    val character: String,
    val photoURL: String
)
