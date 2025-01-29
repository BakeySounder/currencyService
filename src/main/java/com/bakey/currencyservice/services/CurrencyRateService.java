package com.bakey.currencyservice.services;

import com.bakey.currencyservice.CurrencyRateClient;
import com.bakey.currencyservice.models.CurrencyRate;
import com.bakey.currencyservice.repositories.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyRateService {
    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @Autowired
    private CurrencyRateClient currencyRateClient;

    public CurrencyRate saveCurrencyRate(CurrencyRate currencyRate) {
        return currencyRateRepository.save(currencyRate);
    }

    public List<CurrencyRate> getAllCurrencyRates() {
        return currencyRateRepository.findAll();
    }

    public CurrencyRate fetchAndSaveCurrencyRate(String fromCurrency, String toCurrency) {
        CurrencyRate currencyRate = currencyRateClient.getCurrencyRate(fromCurrency, toCurrency);
        return saveCurrencyRate(currencyRate);
    }
}