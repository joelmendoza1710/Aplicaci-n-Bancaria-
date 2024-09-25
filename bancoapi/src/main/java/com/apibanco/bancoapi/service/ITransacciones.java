package com.apibanco.bancoapi.service;

import java.util.List;

import com.apibanco.bancoapi.model.entity.Transacciones;

public interface ITransacciones {
    Transacciones save(Transacciones Transacciones);

    Transacciones findbyTransacciones(Integer id);

    void delete(Transacciones transacciones);
    
    List<Transacciones> getAll();

}
