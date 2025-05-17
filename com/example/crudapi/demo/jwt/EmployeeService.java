package com.example.crudapi.demo.jwt;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Lazy
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    
    public Employee register(EmployeeDTO employeeDto) {
        String rawPassword = employeeDto.getPassword();

        if (rawPassword == null || rawPassword.isEmpty()) {
            throw new IllegalArgumentException("Password must not be null or empty");
        }

        if (employeeRepository.findByUsername(employeeDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        String encodedPassword = passwordEncoder.encode(rawPassword);

        Employee employee = new Employee();
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(encodedPassword);
        employee.setEmail(employeeDto.getEmail());         
        employee.setDepartment(employeeDto.getDepartment()); 

        return employeeRepository.save(employee);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                employee.getUsername(),
                employee.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

    
    
    
}
