package com.iagocarvalho.valorantapp.navigate

enum class ValorantScreensNavitaion {
    AgentsValorantScreen,
    DetalhesScreen;


    companion object{
        fun FromRoute(route: String): ValorantScreensNavitaion
        = when(route?.substringBefore("/")){
            AgentsValorantScreen.name -> AgentsValorantScreen
            DetalhesScreen.name -> DetalhesScreen
            null -> AgentsValorantScreen
            else -> throw IllegalArgumentException( "Route $route is no recognized")
        }
    }
}