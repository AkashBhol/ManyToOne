package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Company;
import com.example.demo.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByCompany(Company countBy);

}
