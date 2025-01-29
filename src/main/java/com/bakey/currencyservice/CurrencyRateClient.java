package com.bakey.currencyservice;


import com.bakey.currencyservice.models.CurrencyRate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Component
public class CurrencyRateClient {

    @Value("${external.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public CurrencyRateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyRate getCurrencyRate(String fromCurrency, String toCurrency) {
        String url = String.format("https://www.alphavantage.co/query?function=FX_DAILY&from_symbol=%s&to_symbol=%s&apikey=%s",
                fromCurrency, toCurrency, apiKey);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        String latestDate = ((Map<String, Object>)response.get("Meta Data")).get("3. Last Refreshed").toString();
        // Извлечение курса из ответа
        BigDecimal rate = new BigDecimal(((Map<String, Object>)((Map<String, Object>)response.get("Time Series FX (Daily)")).get(latestDate)).get("4. close").toString());

        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setCurrencyPair(fromCurrency + "/" + toCurrency);
        currencyRate.setRate(rate);
        currencyRate.setDate(LocalDateTime.parse(latestDate));

        return currencyRate;
    }
}