package com.example.crudapi.demo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

	  @Autowired
	    private AuthenticationManager authenticationManager;

	  @Autowired
	  private EmployeeRepository employeeRepository;
	  
	    @Autowired
	    private JwtUtil jwtUtil;
	    
	    @Autowired
	    private EmployeeService employeeService;

	    @Override
	    public LoginResponse authenticateUser(LoginRequest request) throws Exception {
	        // This will throw exception if authentication fails
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getUsername(), request.getPassword()));
	        
	        Employee employee = employeeRepository.findByUsername(request.getUsername())
	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	        
	        String token = jwtUtil.generateToken(
	        		request.getUsername(),
	        		request.getEmail(),
	        		request.getDepartment()
	        		);

	        return new LoginResponse(token);
	    }
}
