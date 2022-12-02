package com.kugemi.marvelapp.ui.navigation

sealed class NavRoutes(val route: String) {
    object Home: NavRoutes("home")
    object Details: NavRoutes("details")
    object Filters: NavRoutes("filters")
}