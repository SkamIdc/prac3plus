package com.example.myapplication.content

import android.annotation.SuppressLint
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class NavigationBarItemData(val route: String, val icon: androidx.compose.ui.graphics.vector.ImageVector, val label: String)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainActivityScreen() {
    val navController = rememberNavController()
    val items = listOf(
        NavigationBarItemData("movies", Icons.AutoMirrored.Filled.List, "Фильмы"),
        NavigationBarItemData("profile", Icons.Rounded.Person, "Профиль")
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, items) }
    ) { _ ->
        NavigationBar(navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, items: List<NavigationBarItemData>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
            .height(80.dp)
            .shadow(20.dp)
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (isSelected) Color.White else Color.Gray,
                        modifier = Modifier.size(50.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.DarkGray
                ),
                modifier = Modifier.padding(top = 20.dp),
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}