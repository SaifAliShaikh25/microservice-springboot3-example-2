package com.example2microservice.employeeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example2microservice.employeeservice.model.Employee;
import com.example2microservice.employeeservice.repository.EmployeeRepository;
import com.example2microservice.employeeservice.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getAllEmployeesTest() {
		when(employeeRepository.findAll()).thenReturn(Stream
				.of(new Employee(1L, "Bhumi", "BA", 29, 101L), 
						new Employee(2L, "Priyanka", "Tester", 27, 201L))
				.collect(Collectors.toList()));
		assertEquals(2, employeeService.getAll().size());
	}

	
	@Test
	public void getEmployeesByIdTest() {
		Long id = 101L;
		when(employeeRepository.findById(id)).thenReturn(Optional
				.of(new Employee(101L, "Bhumi", "BA", 29, 121L)));
		assertEquals(1, employeeService.getEmployeeById(id).stream().collect(Collectors.toList()).size());
	}

	@Test
	public void getEmployeesByDepartmentTest() {
		when(employeeRepository.findByDepartmentId(101L))
		.thenReturn(Stream.of(
				new Employee(11L, "BHumi", "ba", 29, 131L))
				.collect(Collectors.toList()));
		assertEquals(1, employeeService.getEmployeesByDepartment(101L).size());
	}
}
