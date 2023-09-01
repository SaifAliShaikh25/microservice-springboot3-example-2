package com.example2microservice.departmentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example2microservice.departmentservice.model.Department;
import com.example2microservice.departmentservice.repository.DepartmentRepositoryInterface;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepositoryInterface departmentRepositoryInterface;

	public List<Department> getAllDepartments() {

		return departmentRepositoryInterface.findAll();
	}

	public Department saveDepartment(Department department) {
		
		return departmentRepositoryInterface.save(department);
	}

	public Optional<Department> getDepartment(Long id) {

		return departmentRepositoryInterface.findById(id);
	}

	public List<Department> findAll() {

		return departmentRepositoryInterface.findAll();
	}
}
