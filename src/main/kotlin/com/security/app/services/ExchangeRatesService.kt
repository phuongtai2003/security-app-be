package com.security.app.services

import com.security.app.dao.ExchangeResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class ExchangeRatesService(
    private val webClient: WebClient
) {
    private val exchangeRateApiKey = System.getenv("EXCHANGE_RATES_API_KEY")
    fun getExchangeRatesList() : ExchangeResponse? {
        return webClient.get()
            .uri{
                it.path("/latest")
                    .queryParam("access_key", exchangeRateApiKey)
                    .build()
            }
            .retrieve()
            .bodyToMono(ExchangeResponse::class.java).block()
    }
}