package com.bakey.currencyservice.services;

import com.bakey.currencyservice.models.Transaction;
import com.bakey.currencyservice.repositories.TransactionRepository;
import com.bakey.currencyservice.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    public TransactionServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction();
        transaction.setAccountFrom("0000000123");
        transaction.setAccountTo("9999999999");
        transaction.setCurrencyShortName("KZT");
        transaction.setSum(new BigDecimal("10000.45"));
        transaction.setExpenseCategory("product");
        transaction.setDatetime(LocalDateTime.now());

        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        assertEquals(transaction, savedTransaction);
    }
}