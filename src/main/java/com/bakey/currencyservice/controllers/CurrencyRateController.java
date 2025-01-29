package com.bakey.currencyservice.controllers;

import com.bakey.currencyservice.models.CurrencyRate;
import com.bakey.currencyservice.services.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency-rates")
public class CurrencyRateController {
    @Autowired
    private CurrencyRateService currencyRateService;

    @PostMapping
    public ResponseEntity<CurrencyRate> createCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        CurrencyRate savedCurrencyRate = currencyRateService.saveCurrencyRate(currencyRate);
        return ResponseEntity.ok(savedCurrencyRate);
    }

    @GetMapping
    public ResponseEntity<List<CurrencyRate>> getAllCurrencyRates() {
        List<CurrencyRate> currencyRates = currencyRateService.getAllCurrencyRates();
        return ResponseEntity.ok(currencyRates);
    }

    @PostMapping("/fetch")
    public ResponseEntity<CurrencyRate> fetchAndSaveCurrencyRate(@RequestParam String fromCurrency, @RequestParam String toCurrency) {
        CurrencyRate currencyRate = currencyRateService.fetchAndSaveCurrencyRate(fromCurrency, toCurrency);
        return ResponseEntity.ok(currencyRate);
    }
}
