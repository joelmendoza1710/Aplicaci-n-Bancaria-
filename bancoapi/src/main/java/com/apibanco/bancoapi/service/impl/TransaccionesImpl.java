package com.apibanco.bancoapi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apibanco.bancoapi.model.dao.TrasaccionesDao;
import com.apibanco.bancoapi.model.entity.Transacciones;
import com.apibanco.bancoapi.service.ITransacciones;

@Service
public class TransaccionesImpl implements ITransacciones {

    @Autowired
    private TrasaccionesDao trasaccionesDao;

    @Transactional
    @Override
    public Transacciones save(Transacciones Transacciones) {
        return trasaccionesDao.save(Transacciones);
    }
  

    @Transactional(readOnly = true)
    @Override
    public Transacciones findbyTransacciones(Integer id) {
        return trasaccionesDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Transacciones transacciones) {
        trasaccionesDao.delete(transacciones);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Transacciones> getAll() {
        // Devolver todas las cuentas
        return (List<Transacciones>) trasaccionesDao.findAll();
    }

}
