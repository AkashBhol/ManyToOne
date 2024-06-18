package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Company;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Result;
import com.example.demo.service.ComapnyService;

@RequestMapping("/api")
@RestController
public class ComanyController {
	
	@Autowired
	private ComapnyService  comapnyService;
	
	
	@PostMapping("/craete")
	public Result company(@RequestBody Company company) {
      return comapnyService.craeteComapny(company);
	}
	
	@GetMapping("/get")
	public List<Company> getAllComapny(){
		return comapnyService.getALlCpmany();
	}
	
	@GetMapping("/employe")
	public Result findByName(@RequestParam("name") String name){
		return comapnyService.findByName(name);
	}

}
