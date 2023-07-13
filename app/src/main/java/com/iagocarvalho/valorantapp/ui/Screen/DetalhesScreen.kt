package com.iagocarvalho.valorantapp.ui.Screen

import android.view.Display
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController

@Composable
fun DetalhesScreen(
    navController: NavController,
    viewModel: DetalhesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {
    val valorantDetalhesCards = viewModel.valorantAgents.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorantAgents()
    }
    Text(text = "DetalheScreen")


   // val agentsData = viewModel.valorantAgents.observeAsState()



}