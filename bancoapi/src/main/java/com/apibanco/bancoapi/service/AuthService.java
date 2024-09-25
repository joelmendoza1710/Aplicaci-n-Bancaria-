package com.apibanco.bancoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apibanco.bancoapi.Jwt.JwtService;
import com.apibanco.bancoapi.model.User.Role;
import com.apibanco.bancoapi.model.User.User;
import com.apibanco.bancoapi.model.dao.UsuarioDao;
import com.apibanco.bancoapi.model.payload.AuthResponse;
import com.apibanco.bancoapi.model.payload.LoginRequest;
import com.apibanco.bancoapi.model.payload.RegisterRequest;

@Service
public class AuthService {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired

    private JwtService jwtService;
    @Autowired

    private PasswordEncoder passwordEncoder;
    @Autowired

    private AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=usuarioDao.findByUsername(request.getUsername()).orElseThrow();
        User users=usuarioDao.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .result(users)
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(Role.USER)
                .build();

        usuarioDao.save(user);

        return AuthResponse.builder()
                 .result(user)
                .token(jwtService.getToken(user))
                .build();

    }
}
