package com.example.myapplication.content

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.myapplication.view.DetailsViewModel
import com.example.myapplication.view.MovieDetailsUI
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailsScreen(navController: NavHostController, movieId: Int) {
    val viewModel = koinViewModel<DetailsViewModel> { parametersOf(navController, movieId) }
    viewModel.uiState.value?.let { movie ->
        MovieDetails(movie, onBackPressed = { viewModel.back() })
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetails(
    movie: MovieDetailsUI,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = movie.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
                        fontSize = 24.sp,
                    )
                ) },

                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AsyncImage(
                model = movie.posterURL,
                contentDescription = "Постер ${movie.name}",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = movie.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(5.dp)
            )

            EntityDetailsSection(movie.details)

            Text(
                text = "Актеры",
                style = MaterialTheme.typography.titleLarge.copy(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    fontSize = 28.sp,
                ),
                modifier = Modifier.fillMaxWidth()
            )

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                movie.persons.forEach { person ->
                    Card(
                        modifier = Modifier
                            .width( (LocalConfiguration.current.screenWidthDp.dp - 15.dp*2 - 20.dp) / 2 )
                            .height(250.dp)
                        ,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            AsyncImage(
                                model = person.photoURL,
                                contentDescription = "Photo ${person.name}",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .fillMaxWidth()
                                    .height(180.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(person.name, fontWeight = FontWeight.Medium, fontSize = 16.sp)
                            Text(person.character, fontSize = 14.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}

@Composable
fun EntityDetailsSection(attributes: List<Pair<String, String>>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        attributes.forEach { (label, value) ->
            Text(
                text = "$label: $value",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
            )
        }
    }
}
