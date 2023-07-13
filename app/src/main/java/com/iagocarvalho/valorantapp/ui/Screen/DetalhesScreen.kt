package com.iagocarvalho.valorantapp.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController

@Composable
fun DetalhesScreen(
    navController: NavController,
    viewModel: DetalhesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {
    val agentsData = viewModel.valorantAgents.observeAsState()
    Column() {
        Text(text = agentsData.value!!.uuid)
    }


}