package com.bakey.currencyservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_from", nullable = false)
    private String accountFrom;

    @Column(name = "account_to", nullable = false)
    private String accountTo;

    @Column(name = "currency_shortname", nullable = false)
    private String currencyShortName;

    @Column(name = "sum", nullable = false)
    private BigDecimal sum;

    @Column(name = "expense_category", nullable = false)
    private String expenseCategory;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;
}