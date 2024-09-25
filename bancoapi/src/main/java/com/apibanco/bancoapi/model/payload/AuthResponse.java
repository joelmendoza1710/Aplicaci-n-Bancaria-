package com.apibanco.bancoapi.model.payload;

import com.apibanco.bancoapi.model.User.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    User result;
    String token;


}
