package com.example2microservice.departmentservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example2microservice.departmentservice.model.Department;
import com.example2microservice.departmentservice.model.DepartmentEmployeeDetails;
import com.example2microservice.departmentservice.model.Employee;
import com.example2microservice.departmentservice.service.ApiToEmployee;
import com.example2microservice.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ApiToEmployee apiToEmployee;

	/*
	 * @Autowired private EmployeeClient employeeClient;
	 */

	@GetMapping
	public List<Department> getAllDepartments() {

		return departmentService.getAllDepartments();
	}

	@PostMapping
	public Department saveDepartment(@RequestBody Department department) {

		return departmentService.saveDepartment(department);
	}

	@GetMapping("/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") Long id) {

		return departmentService.getDepartment(id);
	}

	@GetMapping("/employees")
	public List<DepartmentEmployeeDetails> getEmployees() {

		// fetch all departments
		List<Department> departments = departmentService.getAllDepartments();

		// fetch all employees
		Employee[] emp = apiToEmployee.employees();
		List<Employee> empList = Arrays.asList(emp);

		List<DepartmentEmployeeDetails> ded = new ArrayList<DepartmentEmployeeDetails>();

		// check department id from departments in employees
		for (Department department : departments) {
			List<Employee> empList2 = empList.stream().filter(emp2 ->  emp2.getDepartmentId().equals(department.getId())).collect(Collectors.toList());
			
			// set department details and employee details in ded object
			ded.add(new DepartmentEmployeeDetails(department.getId(), department.getName(), empList2));
		}
		 return ded;
	}
}
