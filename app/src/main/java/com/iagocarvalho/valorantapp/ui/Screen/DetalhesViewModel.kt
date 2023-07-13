package com.iagocarvalho.valorantapp.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagocarvalho.valorantapp.model.Responses.Data
import com.iagocarvalho.valorantapp.model.ValorantRespository
import kotlinx.coroutines.launch

class DetalhesViewModel(): ViewModel() {

    private val respository = ValorantRespository()

    private val _ValorantDetalhes = MutableLiveData<List<Data>>()
    val ValorantDetalhes: LiveData<List<Data>> = _ValorantDetalhes

    fun fetDetalhesValorant(){
        viewModelScope.launch {
            try {
                val agents = respository.getDetalhesValorant()
                _ValorantDetalhes.value = agents
            }catch (e: Exception){
                Log.d("EXC", "fetValorantAgents: ${e.message.toString()}")
            }
        }
    }
}