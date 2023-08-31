package com.example2microservice.employeeservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example2microservice.employeeservice.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	List<Employee> findByDepartmentId(Long departmentId);

}
