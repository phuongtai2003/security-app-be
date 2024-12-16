package com.security.app.dao
import com.fasterxml.jackson.annotation.JsonProperty

data class ExchangeResponse(
    val success: Boolean,
    val timestamp: Long,
    val base: String,
    val date: String,
    val rates: Rates,
)

data class Rates(
    @JsonProperty("USD")
    val usd: Double,
    @JsonProperty("VND")
    val vnd: Double,
    )
