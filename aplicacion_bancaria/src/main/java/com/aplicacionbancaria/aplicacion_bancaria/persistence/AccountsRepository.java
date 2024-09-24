package com.aplicacionbancaria.aplicacion_bancaria.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplicacionbancaria.aplicacion_bancaria.domain.Account;
import com.aplicacionbancaria.aplicacion_bancaria.domain.repository.AccountRepository;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.crud.AccountCrudRepository;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Accounts;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.mapper.AccountMapper;

@Repository
public class AccountsRepository implements AccountRepository {
    @Autowired
    private AccountMapper mapper;
    @Autowired
    private AccountCrudRepository accountCrudRepository;
@Override
    public List<Account> getAll() {
        List<Accounts>accounts = (List<Accounts>) accountCrudRepository.findAll();
        return mapper.toaccounts(accounts);
    }
    @Override
    public List<Account> getByAccounts(int usuarioId){
        List<Accounts> accounts = accountCrudRepository.findByusuarioId(usuarioId);
        return mapper.toaccounts(accounts);
    }
    @Override
    public Account save(Account account){
        Accounts accounts= mapper.toaccounts(account);
        return mapper.toaccount(accountCrudRepository.save(accounts));
    }
    @Override
    public void delete(int id){
        accountCrudRepository.deleteById(id);
    }

}
