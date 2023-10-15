package com.example2microservice.employeeservice;

import com.example2microservice.employeeservice.controller.EmployeeController;
import com.example2microservice.employeeservice.model.Employee;
import com.example2microservice.employeeservice.repository.EmployeeRepository;
import com.example2microservice.employeeservice.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeController employeeController;

    @InjectMocks
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;


    @Test
    public void update_Employee_Test(){
        Employee employee = Employee.builder().name("Bhumi").position("Senior Business Analyst").build();
        Employee newEmployee = Employee.builder().name("Bhumi Shiroya").position("Business Analyst").build();

        Mockito.when(employeeController.updateEmployee(1L, employee)).thenReturn(ResponseEntity.ok(Optional.ofNullable(newEmployee)));
        ResponseEntity<Optional<Employee>> updatedEmployee = employeeController.updateEmployee(1L, employee);
        assertTrue(updatedEmployee.getStatusCode().is2xxSuccessful());
        assertEquals("Bhumi Shiroya", updatedEmployee.getBody().get().getName());

    }
}
