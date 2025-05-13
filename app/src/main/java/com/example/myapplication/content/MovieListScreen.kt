package com.example.myapplication.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.myapplication.model.Movie
import com.example.myapplication.view.ListViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navigation: NavHostController) {
    val viewModel = koinViewModel<ListViewModel> { parametersOf(navigation) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = "Фильмы",
                    style = MaterialTheme.typography.titleLarge)
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 10.dp, vertical = 5.dp),
        ) {
            val list = viewModel.loadMovies()
            items(list) { movie ->
                MovieCard(movie, onClick = { viewModel.onItemClicked(movie.id) })
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = movie.posterURL,
                contentDescription = "Постер",
                modifier = Modifier
                    .height(150.dp)
                    .padding(start = 8.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${movie.name} (${movie.year})",
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = movie.genres.joinToString(", "),
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "KP: ${movie.rating.kp}, IMDB: ${movie.rating.imdb}",
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

            }

        }
    }
}
