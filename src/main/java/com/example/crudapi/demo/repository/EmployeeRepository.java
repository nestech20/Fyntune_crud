package com.example.crudapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudapi.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByUsername(String username);
	

}
