package com.aplicacionbancaria.aplicacion_bancaria.domain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacionbancaria.aplicacion_bancaria.domain.Transaction;
import com.aplicacionbancaria.aplicacion_bancaria.domain.repository.TrasactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TrasactionRepository trasactionRepository;

    public List<Transaction> getALL(){
        return trasactionRepository.getAll();
        
    }
    public List<Transaction>getByTransactions(int accountoriginid){
        return trasactionRepository.getByTransactions(accountoriginid);
    }
    public Transaction save(Transaction transaction){
        return trasactionRepository.save(transaction);
    }
  
}
