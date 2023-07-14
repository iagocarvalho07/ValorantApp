package com.iagocarvalho.valorantapp.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagocarvalho.valorantapp.model.Responses.Data
import com.iagocarvalho.valorantapp.model.Responses.ModelValorant
import com.iagocarvalho.valorantapp.model.ValorantRespository
import kotlinx.coroutines.launch

class DetalhesScreenViewModel():ViewModel() {

    private val Detalhesrespository = ValorantRespository()

    private val _valorantAgents = MutableLiveData<List<Data>>()
    val valorantAgents: LiveData<List<Data>> = _valorantAgents

    fun fetDetalhesValorantAgents(){
        viewModelScope.launch {
            try {
                val agents = Detalhesrespository.getDetalhesValorant().data
                _valorantAgents.value = agents
            }catch (e: Exception){
                Log.d("EXC", "fetValorantAgents: ${e.message.toString()}")
            }
        }
    }
}