package com.example2microservice.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example2microservice.departmentservice.model.Employee;

@Service
public class ApiToEmployee {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	private static final String employeeBaseUrl = "http://EMPLOYEE-SERVICE/employee";

	public Employee[] employees() {
	//	Employee employeeList = restTemplate.getForObject(employeeBaseUrl, Employee.class);

		ResponseEntity<Employee[]> employeesList = restTemplate.getForEntity(employeeBaseUrl, Employee[].class);
		Employee[] employeeList = employeesList.getBody();

		/*
		 * Employee employee1 = webClientBuilder.build() .get() .uri(employeeBaseUrl)
		 * .retrieve() .bodyToMono(Employee.class) .block();
		 * 
		 * System.out.println("Printing employee details ---");
		 * System.out.println(employee1);
		 */
		return employeeList;
	}

}
