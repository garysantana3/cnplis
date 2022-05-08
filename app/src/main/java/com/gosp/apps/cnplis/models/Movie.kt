package com.gosp.apps.cnplis.models

data class Movie(
    val address: String,
    val city_id: String,
    val id: String,
    val lat: String,
    val lng: String,
    val name: String,
    val phone: String,
    val position: Int,
    val settings: Settings,
    val uris: String,
    val vista_id: String
)