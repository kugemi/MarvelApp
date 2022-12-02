package com.kugemi.marvelapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kugemi.marvelapp.ui.navigation.NavRoutes
import com.kugemi.marvelapp.viewmodels.CharactersViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val charactersViewModel: CharactersViewModel = viewModel()
    
    NavHost(
        navController = navController, 
        startDestination = NavRoutes.Home.route
    ) {
        composable(NavRoutes.Home.route) {
            HomeScreen(
                navController = navController,
                charactersViewModel
            )
        }

        composable(NavRoutes.Details.route) {
            DetailsScreen(
                navController = navController,
                charactersViewModel
            )
        }

        composable(NavRoutes.Filters.route) {
            FiltersScreen(
                navController = navController,
                charactersViewModel = charactersViewModel
            )
        }
    }
}