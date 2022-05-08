package com.gosp.apps.cnplis.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gosp.apps.cnplis.api.CineServices
import com.gosp.apps.cnplis.models.Movie
import com.gosp.apps.cnplis.models.request.LoginRequest
import com.gosp.apps.cnplis.models.response.ListMoviesResponse
import com.gosp.apps.mlapp.mlapp.utils.Enums
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val services: CineServices): ViewModel() {

    var dataList = MutableLiveData<ListMoviesResponse>()

    // Create a LiveData
    val viewState: MutableLiveData<Enums.ViewStates> by lazy {
        MutableLiveData<Enums.ViewStates>()
    }

    init {
        viewState.value = Enums.ViewStates.LOGIN
    }

    fun changeState(state : Enums.ViewStates) {
        viewModelScope.launch {
            viewState.value = state
        }
    }

    fun doLogin(data: LoginRequest,context: Context){
        viewModelScope.launch {
            try {
                val loginResponse = services.setLogin(data)
            }catch (e:Exception){

            }
        }
    }

    fun getMovies(){
        viewModelScope.launch {
            try {
                val moviesResponse = services.getListMovies()
                if (moviesResponse?.movies != null){
                    dataList.value = moviesResponse
                    changeState(Enums.ViewStates.HOME)
                }else{
                    changeState(Enums.ViewStates.SOMETHING_WRONG)
                }

            }catch (e:Exception){

            }
        }
    }

    fun getMovieDetail(id:String, context: Context){

    }

}