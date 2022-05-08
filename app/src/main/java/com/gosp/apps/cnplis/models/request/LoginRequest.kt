package com.gosp.apps.cnplis.models.request

data class LoginRequest (
        var country_code: String? = "MX",
        var username: String,
        var password: String,
        var grant_type: String? = "password",
        var client_id: String? = "IATestCandidate",
        var client_secret: String? = "c840457e777b4fee9b510fbcd4985b68"
    )