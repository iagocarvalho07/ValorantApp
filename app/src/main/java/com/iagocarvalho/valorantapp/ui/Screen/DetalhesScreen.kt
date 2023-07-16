package com.iagocarvalho.valorantapp.ui.Screen

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.animation.core.EaseIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.iagocarvalho.valorantapp.model.Responses.Data
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.util.logging.Logger.global
import kotlin.math.log

@Composable
fun DetalhesScreen(
    navController: NavController,
    uuid: String? = "asda",
    viewModel: DetalhesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {

    val valorantCards by viewModel.valorantAgents.observeAsState(null)
    val filterElement = valorantCards?.filter { it.uuid == uuid }
    var expandableList by remember { mutableStateOf(false) }

    if (filterElement != null) {
        filterElement.forEach { agentsValorantFilter ->
            Column() {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .height(300.dp)
                        .fillMaxWidth()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color.Black,
                                    Color.Gray,
                                    Color.DarkGray,
                                    Color.Gray,
                                    Color.Black
                                )
                            )
                        )
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = agentsValorantFilter.displayName,
                            modifier = Modifier,
                            color = Color.White,
                            fontStyle = FontStyle.Normal
                        )
                        AsyncImage(
                            model = agentsValorantFilter.fullPortrait,
                            contentDescription = "",
                            modifier = Modifier.size(400.dp)
                        )

                    }

                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = agentsValorantFilter.description,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                    Row {
                        Text(
                            text = "Abilidades"
                        )
                        Icon(
                            imageVector = if (expandableList) {
                                Icons.Default.KeyboardArrowDown
                            } else {
                                Icons.Default.KeyboardArrowUp
                            }, contentDescription = "",
                            modifier = Modifier.clickable { expandableList = !expandableList })
                        Log.d("ex", "DetalhesScreen: $expandableList")
                    }
                    if (expandableList) {
                        LazyColumn() {
                            items(agentsValorantFilter.abilities) { abilidades ->
                                Card(modifier = Modifier.padding(16.dp)) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        AsyncImage(
                                            model = abilidades.displayIcon,
                                            contentDescription = "",
                                            modifier = Modifier.background(Color.DarkGray)

                                        )
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier.padding(16.dp)
                                        ) {
                                            Text(text = abilidades.displayName)
                                            Text(text = abilidades.description)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorantAgents()
    }


}

//hjkb


// val agentsData = viewModel.valorantAgents.observeAsState()





