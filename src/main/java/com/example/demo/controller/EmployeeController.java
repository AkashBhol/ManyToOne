package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

@RequestMapping("/api")
@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService  employeeService;
	
	
	@PostMapping("/ecreate")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/get/all")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
}
