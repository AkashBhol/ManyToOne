package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Company;
import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDto;
import com.example.demo.domain.Result;
import com.example.demo.repo.ComanyRepo;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.ComapnyService;
import com.example.demo.util.BasicUtil;

@Service
public class CompanyServiceImpl extends BasicUtil implements ComapnyService{

	@Autowired
	private ComanyRepo comanyRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Result craeteComapny(Company company) {
		boolean validToCreate = isValidToCreate(company);
		if(!validToCreate) {
			return prepareResponseObject("0012", "CompanyNAme All Ready Exist", null);
		}
		 Company save = comanyRepo.save(company);
		 return prepareResponseObject("0022", "CompanyCreated Success Fully", save);
	}

	@Override
	public List<Company> getALlCpmany() {
		return  comanyRepo.findAll();
		
	}
	
	private boolean isValidToCreate(Company company) {
		if(isNullOrEmpty(company)) {
			return true;
		}
		 boolean existsByCompanyName = comanyRepo.existsByCompanyName(company.getCompanyName());
		if(!existsByCompanyName) {
			return true;
		}
		return false;
	}

	@Override
	public Result findByName(String companyName) {
		Company findByName = comanyRepo.findByCompanyName(companyName);
		List<Employee> employees = employeeRepo.findByCompany(findByName);
		List<EmployeeDto> results = employees.stream().map(emp -> {
            EmployeeDto dto=new EmployeeDto();
            dto.setName(emp.getName());
            dto.setAge(emp.getAge());
            dto.setEamil(emp.getEamil());
            return dto;
        }).collect(Collectors.toList());
		Result  result=new Result();
		result.setData(results);
		result.setMessage("Getting all Employees for Zkteco");
		return prepareResponseObject("1012", "Getting allEmployee", result);
	}
}
