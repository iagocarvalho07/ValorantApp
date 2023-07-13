package com.iagocarvalho.valorantapp.Network.api

import com.iagocarvalho.valorantapp.model.Responses.Data
import com.iagocarvalho.valorantapp.model.Responses.ModelValorant
import retrofit2.http.GET

interface ValorantService {
    @GET("agents")
    suspend fun getCreditCars(): ModelValorant



}