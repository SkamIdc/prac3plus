package com.example.myapplication.content

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationBar(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "movies")
    {
        composable("movies") { ListScreen(navController)  }
        composable("movieDetail/{movieId}") {  item ->
            val movieId = item.arguments?.getString("movieId")?.toInt() ?: 0
            DetailsScreen(navController, movieId)
        }
        composable("profile") { ProfileScreen() }
    }
}