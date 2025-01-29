package com.bakey.currencyservice.repositories;

import com.bakey.currencyservice.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}