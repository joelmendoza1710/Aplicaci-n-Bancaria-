package com.aplicacionbancaria.aplicacion_bancaria.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aplicacionbancaria.aplicacion_bancaria.persistence.crud.UsersCrudRepository;
import com.aplicacionbancaria.aplicacion_bancaria.persistence.entity.Users;


@Repository
public class UsersRepository {
    private UsersCrudRepository usersCrudRepository;

    public List<Users> getAll(){
        return (List<Users>) usersCrudRepository.findAll();
    }

}
