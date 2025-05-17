package com.example.crudapi.demo.jwt;

public interface AuthService {
    LoginResponse authenticateUser(LoginRequest request) throws Exception;
}
