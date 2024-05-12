package com.example.employeeproject.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeproject.entity.Employee;
import com.example.employeeproject.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployeesSortedByName() {
        return employeeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }
    
    public List<Employee> getEmployeesByDesignation(String designation) {
        return employeeRepository.findByDesignation(designation);
    }
}