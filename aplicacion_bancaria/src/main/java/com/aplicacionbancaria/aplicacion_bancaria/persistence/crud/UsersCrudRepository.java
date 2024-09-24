package com.aplicacionbancaria.aplicacion_bancaria.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Users;

public interface UsersCrudRepository extends CrudRepository<Users, Integer> {
    

}
