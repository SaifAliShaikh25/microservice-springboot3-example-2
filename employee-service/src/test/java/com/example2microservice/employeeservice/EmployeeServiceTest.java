package com.example2microservice.employeeservice;

import com.example2microservice.employeeservice.model.Employee;
import com.example2microservice.employeeservice.repository.EmployeeRepository;
import com.example2microservice.employeeservice.service.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class) 
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;

	@MockBean
	private EmployeeRepository employeeMockBeanRepository;
	
	@InjectMocks
	private EmployeeService employeeService;

	/*@Mock
	private EmployeeService employeeService;*/


	
	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee(301L, "Chavan", "FrontEnd Developer", 29, 2L);
		
		when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
		
		Employee savedEmployee = employeeService.saveEmployee(employee);
		assertThat(savedEmployee).isNotNull();
		
	}
	
	
	@Test
	public void getEmployeesTest() {
//		Employee employees = Mockito.mock(Employee.class);

		// -- when we Mock Employee Repository and InjectMock of Employee Service
		Employee employees = Employee.builder().name("Chavan").age(29).position("Front End Developer").departmentId(2L).build();
		when(employeeRepository.findById(2L)).thenReturn(Optional.ofNullable(employees));
		Optional<Employee> employee = employeeService.getEmployeeById(2L);
		assertThat(employee).isNotNull();
		Assert.assertEquals("Chavan", employee.get().getName());


		// -- when we Mock Employee Service
		/*when(employeeService.getEmployeeById(2L)).thenReturn(Optional.ofNullable(Employee.builder().name("Smahi").build()));
		Optional<Employee> employee = employeeService.getEmployeeById(2L);
		assertThat(employee).isNotNull();
	//	Assert.assertEquals("Smahi", employeeService.getEmployeeById(2L).get().getName());
		Assert.assertEquals("Smahi", employee.get().getName());*/


//		when(employeeRepository.findById(Mockito.any(Employee))).thenReturn(employees.getId());
		
	}

	@Test
	public void get_Employees_Using_Mockito(){
		// Mockito.mock example
/*		EmployeeRepository employeeMockRepository = Mockito.mock(EmployeeRepository.class);
		Mockito.when(employeeMockRepository.findByName("Saif")).thenReturn(Employee.builder().name("Saif Ali").build());
		Employee emp = employeeMockRepository.findByName("Saif");
		Assert.assertEquals(emp.getName(), "Saif Ali");
		Mockito.verify(employeeMockRepository).findByName("Saif");*/

		// @Mock example
		/*Mockito.when(employeeRepository.findByName("Saif")).thenReturn(Employee.builder().name("Saif Ali").build());
		Employee emp = employeeRepository.findByName("Saif");
		Assert.assertEquals(emp.getName(), "Saif Ali");
		Mockito.verify(employeeRepository).findByName("Saif");*/

		//@MockBean example
		Mockito.when(employeeMockBeanRepository.findByName("Saif")).thenReturn(Employee.builder().name("Saif Ali").build());
		Employee emp = employeeMockBeanRepository.findByName("Saif");
		Assert.assertEquals(emp.getName(), "Saif Ali");
		Mockito.verify(employeeMockBeanRepository).findByName("Saif");


	}

}
