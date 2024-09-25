package com.apibanco.bancoapi.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apibanco.bancoapi.model.User.User;

public interface UsuarioDao extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username); 

}
