package com.example.crudapi.demo.jwt;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByUsername(String username);

	

}
