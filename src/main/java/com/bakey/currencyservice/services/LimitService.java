package com.bakey.currencyservice.services;

import com.bakey.currencyservice.models.Limit;
import com.bakey.currencyservice.repositories.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LimitService {
    @Autowired
    private LimitRepository limitRepository;

    public Limit saveLimit(Limit limit) {
        return limitRepository.save(limit);
    }

    public List<Limit> getAllLimits() {
        return limitRepository.findAll();
    }
}