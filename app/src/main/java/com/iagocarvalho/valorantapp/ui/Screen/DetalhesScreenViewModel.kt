package com.iagocarvalho.valorantapp.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagocarvalho.valorantapp.model.Responses.Data
import com.iagocarvalho.valorantapp.model.ValorantRespository
import kotlinx.coroutines.launch

class DetalhesScreenViewModel(data: Data):ViewModel() {

    private val Detalhesrespository = ValorantRespository()

    private val _valorantAgents = MutableLiveData<Data>()
    val valorantAgents: LiveData<Data> = _valorantAgents

    fun fetDetalhesValorantAgents(){
        viewModelScope.launch {
            try {
                val agents = Detalhesrespository.getDetalhesValorant()
                _valorantAgents.value = agents
            }catch (e: Exception){
                Log.d("EXC", "fetValorantAgents: ${e.message.toString()}")
            }
        }
    }
}