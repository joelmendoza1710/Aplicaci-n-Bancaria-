package com.apibanco.bancoapi.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.apibanco.bancoapi.model.entity.Cuenta;

public interface CuentaDao extends CrudRepository<Cuenta,Integer> {


}
