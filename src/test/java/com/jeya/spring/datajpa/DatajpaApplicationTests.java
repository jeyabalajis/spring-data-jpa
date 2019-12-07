package com.jeya.spring.datajpa;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.jeya.spring.datajpa.entities.Employee;
import com.jeya.spring.datajpa.repos.EmployeeRepository;

@SpringBootTest
class DatajpaApplicationTests {

	@Autowired
	ApplicationContext context;

//	@Test
//	void saveEmployee() {
//		EmployeeRepository empRepo = context.getBean(EmployeeRepository.class);
//
//		Employee emp = new Employee();
//		emp.setId(5);
//		emp.setFirstName("Bala");
//		emp.setLastName("Vimalanathan");
//		
//		Employee save = empRepo.save(emp);
//		System.out.println(save);
//	}
//	
	
	@Test
	void getAllEmployees() {
		EmployeeRepository empRepo = context.getBean(EmployeeRepository.class);
		
//		empRepo.findAll().forEach(e->{
//			System.out.println(e);
//		});		
		
		List<Employee> listEmpBala = empRepo.findByFirstNameContainingIgnoreCase("bala");
		
		int lenList = listEmpBala.size();
		
		assertTrue(lenList==2);
		
//		empRepo.findByFirstNameContainingIgnoreCase("bala").forEach(e->{
//			System.out.println(e);
//		});
		
	}

}
