package com.gosp.apps.cnplis.api

import com.gosp.apps.cnplis.models.request.LoginRequest
import com.gosp.apps.cnplis.models.response.ListMoviesResponse
import com.gosp.apps.cnplis.models.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CineServices @Inject constructor(private val api: CineApiClient) {

    suspend fun setLogin(data: LoginRequest): LoginResponse? {
        return withContext(Dispatchers.IO) {
                val response = api.setLogin(data = data)
            response.body()
        }
    }

    suspend fun getListMovies(): ListMoviesResponse? {
        return withContext(Dispatchers.IO) {
            val response = api.getListMovies()
            response.body()
        }
    }
}