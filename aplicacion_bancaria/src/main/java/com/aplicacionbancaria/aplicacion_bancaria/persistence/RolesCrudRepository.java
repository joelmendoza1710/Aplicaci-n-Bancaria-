package com.aplicacionbancaria.aplicacion_bancaria.persistence;

import org.springframework.stereotype.Repository;

import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Roles;

@Repository
public class RolesCrudRepository {

    private RolesCrudRepository rolesCrudRepository;

    public Roles getAll(){
        return rolesCrudRepository.getAll();
    }

}
