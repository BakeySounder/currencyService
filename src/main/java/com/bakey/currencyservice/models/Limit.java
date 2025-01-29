package com.bakey.currencyservice.models;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "limits")
public class Limit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monthly_limit", nullable = false)
    private BigDecimal monthlyLimit;

    @Column(name = "category", nullable = false)
    private String category; // product/service

    @Column(name = "limit_datetime", nullable = false)
    private LocalDateTime limitDateTime;
}