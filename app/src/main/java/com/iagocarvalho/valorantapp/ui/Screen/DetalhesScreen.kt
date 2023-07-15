package com.iagocarvalho.valorantapp.ui.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.iagocarvalho.valorantapp.model.Responses.Data
import java.util.logging.Logger.global

@Composable
fun DetalhesScreen(
    navController: NavController,
    uuid: String?,
    viewModel: DetalhesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {

    val valorantCards by viewModel.valorantAgents.observeAsState(null)

    val filterElement = valorantCards?.filter { it.uuid == uuid }

    if (filterElement != null) {
        filterElement.forEach { agentsValorantFilter ->
            Box() {
                AsyncImage(model = agentsValorantFilter.fullPortrait, contentDescription = "" )
            }

//            Column() {
//                Text(text = "testando filter ${agentsValorantFilter.displayName}")
//                Text(text = agentsValorantFilter.description)
//                Text(text = agentsValorantFilter.abilities[0].displayName)
//                Text(text = agentsValorantFilter.abilities[0].description)
//                AsyncImage(model = agentsValorantFilter.abilities[0].displayIcon, contentDescription = "",
//                    colorFilter = ColorFilter.tint(
//                        Color.LightGray))
//                AsyncImage(model = agentsValorantFilter.fullPortrait, contentDescription = "")
//
//            }


        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorantAgents()
    }

}