package com.example.crudapi.demo.service;


import com.example.crudapi.demo.dto.LoginRequest;
import com.example.crudapi.demo.dto.LoginResponse;

public interface AuthService {
    LoginResponse authenticateUser(LoginRequest request) throws Exception;
}
