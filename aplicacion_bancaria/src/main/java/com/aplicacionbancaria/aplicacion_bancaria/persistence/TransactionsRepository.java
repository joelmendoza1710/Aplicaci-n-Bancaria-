package com.aplicacionbancaria.aplicacion_bancaria.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplicacionbancaria.aplicacion_bancaria.domain.Transaction;
import com.aplicacionbancaria.aplicacion_bancaria.domain.repository.TrasactionRepository;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.crud.TransactionsCrudRepository;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Transactions;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.mapper.TransactionMapper;

@Repository
public class TransactionsRepository implements TrasactionRepository {
    @Autowired
    private TransactionMapper mapper;
    @Autowired
    private TransactionsCrudRepository transactionsCrudRepository;


    @Override
    public List<Transaction> getAll() {
        List<Transactions>transactions = (List<Transactions>) transactionsCrudRepository.findAll();
        return mapper.totransactions(transactions);
    }

    @Override
    public List<Transaction> getByTransactions(int accountoriginid ){
        List<Transactions> transactions = transactionsCrudRepository.findByCuentaOrigenId(accountoriginid);
        return mapper.totransactions(transactions);
    }

      @Override
    public Transaction save(Transaction transaction){
        Transactions transactions= mapper.totransactionsinverse(transaction);
        return mapper.toTransaction(transactionsCrudRepository.save(transactions));
    }

   
   @Override
    public void delete(int id){
        transactionsCrudRepository.deleteById(id);
    }

}
