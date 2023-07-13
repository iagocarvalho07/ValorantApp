package com.iagocarvalho.valorantapp.model.Responses

data class VoiceLine(
    val maxDuration: Double,
    val mediaList: List<Media>,
    val minDuration: Double
)