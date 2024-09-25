package com.apibanco.bancoapi.service;

import java.util.List;

import com.apibanco.bancoapi.model.entity.Cuenta;

public interface ICuenta {

    Cuenta save(Cuenta cuenta);

    Cuenta findbyCuenta(Integer id);

    void delete(Cuenta cuenta);
    
    List<Cuenta> getAll();
    
}
