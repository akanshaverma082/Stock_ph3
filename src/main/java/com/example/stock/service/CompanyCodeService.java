package com.example.stock.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Entity.CompanyCode;
import com.example.stock.repository.CompanyCodeRepo;

@Service
public class CompanyCodeService {
	@Autowired
	CompanyCodeRepo repository;
	
	public CompanyCode saveCompanyCode(CompanyCode companyCode) {
		return repository.save(companyCode);
	}
	
	public CompanyCode findByCompanyCode(int companyCode) {
		return repository.findByCompanyCode(companyCode);
	}

}
