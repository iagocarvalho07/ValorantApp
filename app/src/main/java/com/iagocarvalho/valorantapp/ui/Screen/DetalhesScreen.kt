package com.iagocarvalho.valorantapp.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DetalhesScreen(
    navController: NavController,
    uuid: String?,
    displayName: String?,
    developerName: String?,
    viewModel: DetalhesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {
    val valorantCards by viewModel.valorantAgents.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorantAgents()
    }

    //NEW
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "uuid $uuid")
        Text(text = "displayName $displayName")
        Text(text = "developerName $developerName")
    }
   //

    // valorantCards?.get(0)?.let {
    //    Column() {
    //        Text(text = it.uuid)
    //        Text(text = it.displayName)
    //    }
    // }


    // val agentsData = viewModel.valorantAgents.observeAsState()


}