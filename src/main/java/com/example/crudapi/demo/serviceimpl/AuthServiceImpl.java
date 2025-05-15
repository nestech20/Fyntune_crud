package com.example.crudapi.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.crudapi.demo.dto.LoginRequest;
import com.example.crudapi.demo.dto.LoginResponse;
import com.example.crudapi.demo.jwt.JwtUtil;
import com.example.crudapi.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	  @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Override
	    public LoginResponse authenticateUser(LoginRequest request) throws Exception {
	        // This will throw exception if authentication fails
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getUsername(), request.getPassword()));

	        String token = jwtUtil.generateToken(request.getUsername());

	        return new LoginResponse(token);
	    }
}
