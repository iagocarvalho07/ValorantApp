package com.iagocarvalho.valorantapp.ui.Screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.iagocarvalho.valorantapp.model.Responses.ModelValorant
import com.iagocarvalho.valorantapp.navigate.ValorantScreensNavitaion
import okhttp3.internal.userAgent

@Composable
fun AgentsValorantScreen(
    navController: NavController,
    viewModel: AgentsValorantViewModel = viewModel()
) {

    val valorantCards by viewModel.valorantAgents.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetValorantAgents()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (valorantCards == null) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(valorantCards!!.data) { valorantCards ->
                    CreditCardItem(
                        navController = navController,
                        name = valorantCards.displayName,
                        description = valorantCards.description,
                        displayIcon = valorantCards.displayIcon
                    )
                    Button(onClick = { navController.navigate(ValorantScreensNavitaion.DetahlesScreen.name) }) {

                    }

                    Text(text = valorantCards.abilities[0].slot)
                    Text(text = valorantCards.abilities[0].displayName)
                    Text(text = valorantCards.abilities[0].description)
                    AsyncImage(model = valorantCards.abilities[0].displayIcon, contentDescription = "", colorFilter = ColorFilter.tint(
                        Color.LightGray))
                }
            }
        }


    }
}

@Composable
fun CreditCardItem(
    navController: NavController,
    name: String,
    description: String,
    displayIcon: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(model = displayIcon, contentDescription = "")

        }
    }
}
