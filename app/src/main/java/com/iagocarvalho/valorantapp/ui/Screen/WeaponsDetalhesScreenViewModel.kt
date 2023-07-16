package com.iagocarvalho.valorantapp.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagocarvalho.valorantapp.model.Responses.Data
import com.iagocarvalho.valorantapp.model.ValorantRespository
import kotlinx.coroutines.launch

class WeaponsDetalhesScreenViewModel(): ViewModel() {

    private val Detalhesrespository = ValorantRespository()

    private val _valorantWeapons = MutableLiveData<List<com.iagocarvalho.valorantapp.model.WeponsApi.Data>>()
    val valorantWeapons: LiveData<List<com.iagocarvalho.valorantapp.model.WeponsApi.Data>> = _valorantWeapons

    fun fetDetalhesValorantAgents(){
        viewModelScope.launch {
            try {
                val agents = Detalhesrespository.getWeapons().data
                _valorantWeapons.value = agents
            }catch (e: Exception){
                Log.d("EXC", "fetValorantAgents: ${e.message.toString()}")
            }
        }
    }

}