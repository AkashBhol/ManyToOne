package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Company;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Result;

public interface ComapnyService {

	
	public Result craeteComapny(Company company);
	
	
	public List<Company> getALlCpmany();
	
	public Result findByName(String name);
	
}
