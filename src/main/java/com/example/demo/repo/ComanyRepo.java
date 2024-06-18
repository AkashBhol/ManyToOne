package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Company;

public interface ComanyRepo extends JpaRepository<Company, Integer>{
	boolean existsByCompanyName(String companyName);
	
	public Company findByCompanyName(String companyName);

}
