package com.iagocarvalho.valorantapp.model

import com.iagocarvalho.valorantapp.Network.api.ValorantApi
import com.iagocarvalho.valorantapp.model.Responses.Data
import com.iagocarvalho.valorantapp.model.Responses.ModelValorant
import com.iagocarvalho.valorantapp.model.WeponsApi.Weapons


class ValorantRespository() {
    private val valorantAgentsRepo = ValorantApi.valorantApiService

    suspend fun getValorantCards(): ModelValorant{
        return valorantAgentsRepo.getCreditCars()
    }

    suspend fun getDetalhesValorant(): ModelValorant {
        return valorantAgentsRepo.getCreditCars()
    }

    suspend fun getWeapons(): Weapons{
        return valorantAgentsRepo.getweapons()
    }

}