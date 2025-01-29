package com.bakey.currencyservice.controllers;

import com.bakey.currencyservice.models.Transaction;
import com.bakey.currencyservice.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup(transactionController).build();
    }

    @Test
    public void testCreateTransaction() throws Exception {
        Transaction transaction = new Transaction();
        transaction.setAccountFrom("0000000123");
        transaction.setAccountTo("9999999999");
        transaction.setCurrencyShortName("KZT");
        transaction.setSum(new BigDecimal("10000.45"));
        transaction.setExpenseCategory("product");

        when(transactionService.saveTransaction(transaction)).thenReturn(transaction);

        mockMvc.perform(post("/api/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"accountFrom\":\"0000000123\", \"accountTo\":\"9999999999\", \"currencyShortName\":\"KZT\", \"sum\":10000.45, \"expenseCategory\":\"product\"}"))
                .andExpect(status().isOk());
    }
}