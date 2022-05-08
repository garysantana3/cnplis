package com.gosp.apps.cnplis.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gosp.apps.cnplis.api.CineServices
import com.gosp.apps.cnplis.models.request.LoginRequest
import com.gosp.apps.mlapp.mlapp.utils.Enums
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val services: CineServices): ViewModel() {

    // Create a LiveData
    val viewState: MutableLiveData<Enums.ViewStates> by lazy {
        MutableLiveData<Enums.ViewStates>()
    }

    init {
        viewState.value = Enums.ViewStates.LOGIN
    }

    fun doLogin(data: LoginRequest,context: Context){
        viewModelScope.launch {
            try {
                val loginResponse = services.setLogin(data)
            }catch (e:Exception){

            }
        }
    }
}