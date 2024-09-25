package com.apibanco.bancoapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apibanco.bancoapi.model.dao.CuentaDao;
import com.apibanco.bancoapi.model.entity.Cuenta;
import com.apibanco.bancoapi.service.ICuenta;


@Service
public class CuentaImpl implements ICuenta {

    @Autowired
    private CuentaDao cuentadao;


    @Transactional
    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentadao.save(cuenta);
    }
  

    @Transactional(readOnly = true)
    @Override
    public Cuenta findbyCuenta(Integer id) {
        return cuentadao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cuenta cuenta) {
        cuentadao.delete(cuenta);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cuenta> getAll() {
        // Devolver todas las cuentas
        return (List<Cuenta>) cuentadao.findAll();
    }
}