package com.example2microservice.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example2microservice.departmentservice.model.Department;
@Repository
public interface DepartmentRepositoryInterface extends JpaRepository<Department, Long> {

}
