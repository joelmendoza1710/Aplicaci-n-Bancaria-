package com.aplicacionbancaria.aplicacion_bancaria.domain.repository;

import java.util.List;

import com.aplicacionbancaria.aplicacion_bancaria.domain.Transaction;

public interface TrasactionRepository {
    List<Transaction> getAll();
    List<Transaction> getByTransactions(int accountoriginid);
    Transaction save(Transaction transaction);
    void delete(int transactionid);

}
