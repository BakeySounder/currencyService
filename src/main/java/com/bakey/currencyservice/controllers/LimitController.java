package com.bakey.currencyservice.controllers;

import com.bakey.currencyservice.models.Limit;
import com.bakey.currencyservice.services.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/limits")
public class LimitController {
    @Autowired
    private LimitService limitService;

    @PostMapping
    public ResponseEntity<Limit> createLimit(@RequestBody Limit limit) {
        Limit savedLimit = limitService.saveLimit(limit);
        return ResponseEntity.ok(savedLimit);
    }

    @GetMapping
    public ResponseEntity<List<Limit>> getAllLimits() {
        List<Limit> limits = limitService.getAllLimits();
        return ResponseEntity.ok(limits);
    }
}