package com.iagocarvalho.valorantapp.ui.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun WeaponsScreen(
    navController: NavController,
    viewModel: WeaponsScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    
    val ValorantWeapons by viewModel.valorantWeapons.observeAsState(null)
    LaunchedEffect(Unit){
        viewModel.fetValorantWeapons()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (ValorantWeapons == null){
            CircularProgressIndicator()
        }else{
            LazyColumn(){items(ValorantWeapons!!.data){ weapons ->
                AsyncImage(model = weapons.displayIcon, contentDescription = "")
                
            }
                
            }
        }
    }
}