package com.aplicacionbancaria.aplicacion_bancaria.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Transactions;

public interface TransactionsCrudRepository extends CrudRepository<Transactions,Integer> {
    List<Transactions> findByCuentaOrigenId(int cuentaOrigenId);

}
