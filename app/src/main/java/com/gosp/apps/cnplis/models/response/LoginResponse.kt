package com.gosp.apps.cnplis.models.response

data class LoginResponse(
    val expires: String,
    val issued: String,
    val access_token: String,
    val client_id: String,
    val country_code: String,
    val expires_in: String,
    val refresh_token: String,
    val token_type: String,
    val username: String
)