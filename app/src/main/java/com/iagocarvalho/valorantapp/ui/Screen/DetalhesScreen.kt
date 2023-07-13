package com.iagocarvalho.valorantapp.ui.Screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun DetalhesScreen(
    navController: NavController,
    viewModel: DetalhesViewModel = viewModel()){

    val agentsDetails by viewModel.ValorantDetalhes.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorant()
    }

    agentsDetails?.get(0)?.let { Text(text = it.developerName) }



}