package com.jeya.spring.datajpa.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.jeya.spring.datajpa.entities.Employee;
import com.jeya.spring.datajpa.repos.EmployeeRepository;

@SpringBootTest
public class EmployeeControllerTest {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	@InjectMocks
	EmployeeController empController;
	
	@Mock
	EmployeeRepository empRepo;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createEmployee_Should_Create_An_Employee() {
		
		Employee emp = new Employee();
		Mockito.when(empRepo.save(emp)).thenReturn(new Employee());
		
		empController.createEmployee(emp);
		
		Mockito.verify(empRepo, Mockito.times(1)).save(emp);
	}
}
