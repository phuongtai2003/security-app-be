package com.security.app.controllers

import com.security.app.dao.ExchangeResponse
import com.security.app.services.ExchangeRatesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/exchange-rates")
class ExchangeRatesController(
    private val exchangeRatesService: ExchangeRatesService
) {
    @GetMapping("/")
    fun getExchangeRates() : ResponseEntity<ExchangeResponse>{
        val resp = exchangeRatesService.getExchangeRatesList()
        return if(resp != null){
            ResponseEntity.ok(resp)
        } else{
            ResponseEntity.notFound().build()
        }
    }
}