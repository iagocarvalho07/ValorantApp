package com.iagocarvalho.valorantapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val Tittle: String,
    val icon: ImageVector
){
    object Agents : BottomBarScreen(
        route = "Agentes",
        Tittle = "Agentes",
        icon = Icons.Default.Home
    )
    object Weapons : BottomBarScreen(
        route = "Weapons",
        Tittle = "Weapons",
        icon = Icons.Default.Warning
    )
    object Menu : BottomBarScreen(
        route = "Menu",
        Tittle = "Menu",
        icon = Icons.Default.Menu
    )

}
