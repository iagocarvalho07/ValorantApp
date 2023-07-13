package com.iagocarvalho.valorantapp.ui.Screen

import androidx.lifecycle.ViewModel
import com.iagocarvalho.valorantapp.model.Responses.ModelValorant
import com.iagocarvalho.valorantapp.model.ValorantRepository

class AgentsValorantViewModel(val repository: ValorantRepository = ValorantRepository()): ViewModel() {
    fun getvalorantAgents(): List<ModelValorant>{
        return repository.getValorantAgents().
    }
}