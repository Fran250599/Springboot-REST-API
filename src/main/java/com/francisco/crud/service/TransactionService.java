package com.francisco.crud.service;

import com.francisco.crud.model.Transaction;
import com.francisco.crud.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

    @GetMapping
    public ResponseEntity<Object> getTransactionById(Long id){
        Optional<Transaction> res = transactionRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Dato encontrado:", res.get());
            data.put("Message", "Transacción encontrada.");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }
        data.put("Error", true);
        data.put("Message", "No existe una transacción con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }

    public ResponseEntity<Object> newTransaction(Transaction transaction) {

        Optional<Transaction> res = transactionRepository.findById(transaction.getId());
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Error", true);
            data.put("Message", "Ya existe una transacción con esta fecha.");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }

        transactionRepository.save(transaction);
        data.put("Message", "Transacción creada.");
        data.put("Dato creado:", transaction);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }

    // Update transaction
    public ResponseEntity<Object> updateTransaction(Long id, Transaction transaction){
        Optional<Transaction> res = transactionRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if (res.isPresent()){
            // Update transaction with new data
            res.get().setTransactionNumber(transaction.getTransactionNumber());
            res.get().setDate(transaction.getDate());
            res.get().setTime(transaction.getTime());

            data.put("Message", "Transacción actualizada.");
            data.put("Dato actualizado:", transaction);


            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }
        data.put("Error", true);
        data.put("Message", "No existe una transacción con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }

    // Delete transaction
    public ResponseEntity<Object> deleteTransaction(Long id){
        Optional<Transaction> res = transactionRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if (res.isPresent()){
            data.put("Message", "Transacción eliminada.");
            transactionRepository.deleteById(id);
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }
        data.put("Error", true);
        data.put("Message", "No existe una transacción con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }
}
