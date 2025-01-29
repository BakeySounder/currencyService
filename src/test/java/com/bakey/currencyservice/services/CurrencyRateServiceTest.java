package com.bakey.currencyservice.services;

import com.bakey.currencyservice.CurrencyRateClient;
import com.bakey.currencyservice.models.CurrencyRate;
import com.bakey.currencyservice.repositories.CurrencyRateRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CurrencyRateServiceTest {

    @Mock
    private CurrencyRateRepository currencyRateRepository;

    @Mock
    private CurrencyRateClient currencyRateClient;

    @InjectMocks
    private CurrencyRateService currencyRateService;

    public CurrencyRateServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAndSaveCurrencyRate() {
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setCurrencyPair("KZT/USD");
        currencyRate.setRate(new BigDecimal("420.00"));

        when(currencyRateClient.getCurrencyRate("KZT", "USD")).thenReturn(currencyRate);
        when(currencyRateRepository.save(any(CurrencyRate.class))).thenReturn(currencyRate);

        CurrencyRate savedCurrencyRate = currencyRateService.fetchAndSaveCurrencyRate("KZT", "USD");
        assertEquals(currencyRate, savedCurrencyRate);
    }
}