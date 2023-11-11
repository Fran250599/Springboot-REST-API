package com.francisco.crud.controller;

import com.francisco.crud.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.francisco.crud.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getTransactionById(@PathVariable("id") Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public ResponseEntity<Object> newTransaction(@RequestBody Transaction transaction) {
        return transactionService.newTransaction(transaction);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateTransaction(@PathVariable("id") Long id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteTransaction(@PathVariable("id") Long id) {
        return transactionService.deleteTransaction(id);
    }


}
