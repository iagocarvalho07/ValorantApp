package com.iagocarvalho.valorantapp.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagocarvalho.valorantapp.model.ValorantRespository
import com.iagocarvalho.valorantapp.model.WeponsApi.Weapons
import kotlinx.coroutines.launch

class WeaponsScreenViewModel(): ViewModel() {

    private val respository = ValorantRespository()

    private val _ValorantWeapons = MutableLiveData<Weapons>()
    val valorantWeapons: LiveData<Weapons> = _ValorantWeapons

    fun fetValorantWeapons(){
        viewModelScope.launch {
            try {
                val weapons = respository.getWeapons()
                _ValorantWeapons.value = weapons
            }catch (e: Exception){
                Log.d("exc", "fetValorantWeapons: ${e.message}")
            }
        }
    }


}