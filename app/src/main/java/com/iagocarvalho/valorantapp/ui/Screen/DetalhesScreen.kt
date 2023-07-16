package com.iagocarvalho.valorantapp.ui.Screen

import androidx.compose.foundation.layout.Column
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
    val valorantCards by viewModel.valorantAgents.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorantAgents()
    }
    valorantCards?.get(0)?.let {
        Column() {
            Text(text = it.uuid)
            Text(text = it.displayName)}

        }

    //hjkb



   // val agentsData = viewModel.valorantAgents.observeAsState()



}