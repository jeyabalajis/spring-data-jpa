package com.jeya.spring.datajpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeya.spring.datajpa.entities.Employee;
import com.jeya.spring.datajpa.repos.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepository;

	@GetMapping
	public Iterable<Employee> getEmployees() {
		return empRepository.findAll();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return empRepository.save(employee);
	}

	@GetMapping("/{name}")
	public Iterable<Employee> getEmployeeByFirstName(@PathVariable("name") String name) {
		return empRepository.findByFirstNameContainingIgnoreCase(name);
	}
}
