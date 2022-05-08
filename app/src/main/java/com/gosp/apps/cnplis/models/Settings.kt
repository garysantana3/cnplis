package com.gosp.apps.cnplis.models

data class Settings(
    val cs_merchant_id: String,
    val is_special_prices: Boolean,
    val type_food_sales: String,
    val vco_merchant_id: String
)