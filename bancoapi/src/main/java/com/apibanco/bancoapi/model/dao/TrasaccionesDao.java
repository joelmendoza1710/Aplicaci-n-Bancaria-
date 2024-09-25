package com.apibanco.bancoapi.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.apibanco.bancoapi.model.entity.Transacciones;

public interface TrasaccionesDao extends CrudRepository<Transacciones,Integer> {

}
