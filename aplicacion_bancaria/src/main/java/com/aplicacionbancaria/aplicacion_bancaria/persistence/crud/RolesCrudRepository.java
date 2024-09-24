package com.aplicacionbancaria.aplicacion_bancaria.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Roles;

public interface RolesCrudRepository extends CrudRepository<Roles,Integer> {
    

}
