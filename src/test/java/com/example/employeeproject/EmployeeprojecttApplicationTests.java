package com.example.employeeproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.employeeproject.controller.EmployeeController;
import com.example.employeeproject.entity.Employee;
import com.example.employeeproject.service.EmployeeService;

@SpringBootTest
class EmployeeprojecttApplicationTests {
	
	@Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    public void testGetAllEmployees() {
        
        Employee employee1 = new Employee(1L, "Rishab", "Manager");
        Employee employee2 = new Employee(2L, "Saurab", "Developer");

        List<Employee> mockEmployees = Arrays.asList(employee1, employee2);

        
        when(employeeService.getAllEmployees()).thenReturn(mockEmployees);

        
        List<Employee> result = employeeController.getAllEmployees();

        
        assertEquals(mockEmployees, result);
    }

    @Test
    public void testGetEmployeeById() {
        
        Long id = 1L;
        Employee mockEmployee = new Employee(id, "Rahul", "Manager");

  
        when(employeeService.getEmployeeById(id)).thenReturn(mockEmployee);

        
        ResponseEntity<Employee> result = employeeController.getEmployeeById(id);

        
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(mockEmployee, result.getBody());
    }
    @Test
    public void testSaveEmployee() {
        
        Employee employeeToSave = new Employee(null, "Vijay", "Designer");

        
        ResponseEntity<Void> response = employeeController.saveEmployee(employeeToSave);

        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(employeeService).saveEmployee(employeeToSave);
    }

    @Test
    public void testDeleteEmployee() {
        
        Long id = 1L;

        
        ResponseEntity<Void> response = employeeController.deleteEmployee(id);

        
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(employeeService).deleteEmployee(id);
    }

    @Test
    public void testGetAllEmployeesSortedByName() {
        
        Employee employee1 = new Employee(1L, "Hari", "Manager");
        Employee employee2 = new Employee(2L, "Rohit", "Developer");

        List<Employee> mockEmployees = Arrays.asList(employee1, employee2);

        
        when(employeeService.getAllEmployeesSortedByName()).thenReturn(mockEmployees);

        
        List<Employee> result = employeeController.getAllEmployeesSortedByName();

        
        assertEquals(mockEmployees, result);
    }

	
}

