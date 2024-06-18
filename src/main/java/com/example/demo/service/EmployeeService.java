package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Employee;

public interface EmployeeService {

	
	public Employee createEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
}
