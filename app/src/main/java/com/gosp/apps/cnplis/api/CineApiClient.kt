package com.gosp.apps.cnplis.api


import com.gosp.apps.cnplis.models.request.LoginRequest
import com.gosp.apps.cnplis.models.response.ListMoviesResponse
import com.gosp.apps.cnplis.models.response.LoginResponse
import com.gosp.apps.mlapp.mlapp.utils.Enums
import retrofit2.Response
import retrofit2.http.*
import java.util.*


interface CineApiClient {
    //POST

    @POST(Endpoints.LOGIN)
    suspend fun setLogin(
        @Body data: LoginRequest
    ): Response<LoginResponse>

    //GET

    @GET(Endpoints.MOVIES)
    suspend fun getListMovies(): Response<ListMoviesResponse>

}