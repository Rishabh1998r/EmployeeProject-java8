package com.example.employeeproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employeeproject.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.designation = :designation")
    List<Employee> findByDesignation(@PathVariable("designation") String designation);
	
}