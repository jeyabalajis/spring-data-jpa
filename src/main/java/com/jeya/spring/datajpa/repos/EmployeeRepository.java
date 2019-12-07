package com.jeya.spring.datajpa.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeya.spring.datajpa.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByFirstNameContainingIgnoreCase(String firstName);

}
