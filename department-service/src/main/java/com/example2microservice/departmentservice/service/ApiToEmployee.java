package com.example2microservice.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example2microservice.departmentservice.model.Employee;

@Service
public class ApiToEmployee {

	@Autowired
	private RestTemplate restTemplate;

	private static final String employeeBaseUrl = "http://EMPLOYEE-SERVICE/employee";

	public Employee[] employees() {
	//	Employee employeeList = restTemplate.getForObject(employeeBaseUrl, Employee.class);

		 ResponseEntity<Employee[]> employeesList = restTemplate.getForEntity(employeeBaseUrl, Employee[].class);
		Employee[] employeeList = employeesList.getBody();

		return employeeList;
	}

}
