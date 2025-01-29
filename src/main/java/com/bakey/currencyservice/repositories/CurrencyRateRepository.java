package com.bakey.currencyservice.repositories;

import com.bakey.currencyservice.models.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
}