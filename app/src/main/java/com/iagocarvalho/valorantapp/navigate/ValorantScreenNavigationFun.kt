package com.iagocarvalho.valorantapp.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iagocarvalho.valorantapp.ui.Screen.AgentsValorantScreen
import com.iagocarvalho.valorantapp.ui.Screen.DetalhesScreen
import com.iagocarvalho.valorantapp.ui.Screen.WeaponsScreen


@Composable
fun ValorantScreensNavitaionfun() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ValorantScreensNavitaion.AgentsValorantScreen.name
    ) {
        composable(
            route = ValorantScreensNavitaion.AgentsValorantScreen.name) {
            AgentsValorantScreen(navController)
        }
        composable(
            route = ValorantScreensNavitaion.DetalhesScreen.name + "/{uuid}",
            arguments = listOf(
                navArgument("uuid") {
                    type = NavType.StringType
                    nullable = true
                },
            )) {
            DetalhesScreen(
                navController = navController,
                uuid = it.arguments?.getString("uuid") ,
            )
        }
        composable( route = ValorantScreensNavitaion.WeaponsScreen.name){
            WeaponsScreen(navController = navController)
        }

    }
}
