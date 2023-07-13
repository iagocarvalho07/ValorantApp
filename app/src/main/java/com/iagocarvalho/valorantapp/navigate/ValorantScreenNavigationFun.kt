package com.iagocarvalho.valorantapp.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iagocarvalho.valorantapp.ui.Screen.AgentsValorantScreen
import com.iagocarvalho.valorantapp.ui.Screen.DetalhesScreen


@Composable
fun ValorantScreensNavitaionfun() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ValorantScreensNavitaion.AgentsValorantScreen.name
    ) {
        composable(ValorantScreensNavitaion.AgentsValorantScreen.name) {
            AgentsValorantScreen(navController = navController)
        }
        composable(ValorantScreensNavitaion.DetahlesScreen.name){
            DetalhesScreen(navController = navController)
        }

    }
}
