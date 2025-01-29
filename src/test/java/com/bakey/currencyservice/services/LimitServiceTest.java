package com.bakey.currencyservice.services;

import com.bakey.currencyservice.models.Limit;
import com.bakey.currencyservice.repositories.LimitRepository;
import com.bakey.currencyservice.services.LimitService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LimitServiceTest {

    @Mock
    private LimitRepository limitRepository;

    @InjectMocks
    private LimitService limitService;

    public LimitServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveLimit() {
        Limit limit = new Limit();
        limit.setMonthlyLimit(new BigDecimal("1000.00"));
        limit.setCategory("product");
        limit.setLimitDateTime(LocalDateTime.now());

        when(limitRepository.save(any(Limit.class))).thenReturn(limit);

        Limit savedLimit = limitService.saveLimit(limit);
        assertEquals(limit, savedLimit);
    }
}