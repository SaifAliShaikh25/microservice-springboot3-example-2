package com.example2microservice.departmentservice.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentEmployeeDetails {

		private Long id;
		private String name;
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		private List<Employee> employees = new ArrayList<>();

		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}

		@Override
		public String toString() {
			return "DepartmentEmployeeDetails [id=" + id + ", name=" + name + ", employees=" + employees + "]";
		}

		public DepartmentEmployeeDetails() {
			super();
		}
		
		public DepartmentEmployeeDetails(Long id, String name, List<Employee> employees) {
			super();
			this.id = id;
			this.name = name;
			this.employees = employees;
		}

		
		  
		 


	}

