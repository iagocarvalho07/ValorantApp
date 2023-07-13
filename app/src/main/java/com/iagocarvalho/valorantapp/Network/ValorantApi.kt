package com.iagocarvalho.valorantapp.Network

import com.iagocarvalho.valorantapp.model.Responses.ModelValorant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

class ValorantWebService {
    private lateinit var Api: ValorantApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/")
            .build()

        val service : ValorantApi = retrofit.create(ValorantApi::class.java)

    }
    fun getValorantAgents(): Call<ModelValorant> {

    }

    interface ValorantApi{
        @GET("agents")
        fun getValorantAgents(): Call<ModelValorant>
    }
}