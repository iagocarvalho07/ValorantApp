package com.iagocarvalho.valorantapp.navigate

import okhttp3.Route

enum class ValorantScreensNavitaion {
    AgentsValorantScreen,
    DetahlesScreen;


    companion object{
        fun FromRoute(route: String): ValorantScreensNavitaion
        = when(route?.substringBefore("/")){
            AgentsValorantScreen.name -> AgentsValorantScreen
            DetahlesScreen.name -> DetahlesScreen
            null -> AgentsValorantScreen
            else -> throw IllegalArgumentException( "Route $route is no recognized")
        }
    }
}