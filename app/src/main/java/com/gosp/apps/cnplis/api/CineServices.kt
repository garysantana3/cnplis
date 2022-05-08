package com.gosp.apps.cnplis.api

import com.gosp.apps.cnplis.models.request.LoginRequest
import com.gosp.apps.cnplis.models.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CineServices @Inject constructor(private val api: CineApiClient) {

    suspend fun setLogin(data: LoginRequest): LoginResponse? {
        return withContext(Dispatchers.IO) {
                val response = api.setLogin(data = "country_code=MX&username=pruebas_beto_ia%40yahoo.com&password=Pruebas01&grant_type=password&client_id=IATestCandidate&client_secret=c840457e777b4fee9b510fbcd4985b68")
            response.body()
        }
    }
}