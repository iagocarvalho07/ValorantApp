package com.iagocarvalho.valorantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.iagocarvalho.valorantapp.navigate.ValorantScreensNavitaionfun
import com.iagocarvalho.valorantapp.ui.theme.ValorantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    Color.Black,
                                    Color.DarkGray,
                                    Color.Gray
                                )
                            )
                        ), color = Color.DarkGray
                ) {
                    ValorantScreensNavitaionfun()
                }
            }
        }
    }
}
