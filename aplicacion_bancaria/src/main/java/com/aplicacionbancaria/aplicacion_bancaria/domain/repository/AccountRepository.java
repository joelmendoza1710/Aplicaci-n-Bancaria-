package com.aplicacionbancaria.aplicacion_bancaria.domain.repository;

import java.util.List;

import com.aplicacionbancaria.aplicacion_bancaria.domain.Account;

public interface AccountRepository {
    List<Account> getAll();
    List<Account> getByAccounts(int accountid);
    Account save(Account Account);
    void delete(int accountid);

}
