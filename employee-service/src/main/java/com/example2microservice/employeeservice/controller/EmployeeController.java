package com.example2microservice.employeeservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example2microservice.employeeservice.model.Employee;
import com.example2microservice.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class); 

	@PostMapping
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Saving employee in controller");
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmployee(@PathVariable( "id") Long id) {
		
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/department/{departmentId}")
	public List<Employee> getEmployeesByDepartment(@PathVariable("departmentId") Long departmentId){
		
		return employeeService.getEmployeesByDepartment(departmentId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Long id) {
		
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
	Optional<Employee> currentEmployee = employeeService.getEmployeeById(id);
		currentEmployee.get().setName(employee.getName());
		currentEmployee.get().setPosition(employee.getPosition());
		currentEmployee.get().setAge(employee.getAge());
		currentEmployee.get().setDepartmentId(employee.getDepartmentId());
		employeeService.saveEmployee(currentEmployee.get());
		
		return ResponseEntity.ok(currentEmployee);
	}
}
