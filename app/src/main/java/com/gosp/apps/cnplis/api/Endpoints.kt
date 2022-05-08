package com.gosp.apps.cnplis.api

class Endpoints {

    companion object{

        const val BASE_URL = "https://stage-api.cinepolis.com"
        const val HEADER_API_KEY = "stage_HNYh3RaK_Test"

        const val LOGIN  = "/v2/oauth/token"
        const val MOVIES = "/v2/movies?country_code=MX&cinema=61"
    }
}