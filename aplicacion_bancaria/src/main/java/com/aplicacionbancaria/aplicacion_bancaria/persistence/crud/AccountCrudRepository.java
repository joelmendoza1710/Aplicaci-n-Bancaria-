package com.aplicacionbancaria.aplicacion_bancaria.persistence.crud;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Accounts;

public interface AccountCrudRepository extends CrudRepository<Accounts, Integer> {
        List<Accounts> findByusuarioId(int usuarioId);

}
