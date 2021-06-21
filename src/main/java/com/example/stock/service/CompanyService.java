package com.example.stock.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Entity.Company;
import com.example.stock.Entity.IPODetails;
import com.example.stock.repository.CompanyRepo;

@Service
public class CompanyService {
	@Autowired
	CompanyRepo repository;
	
	public Company saveCompany(Company company) {
		return repository.save(company);
	}
	
	public List<Company> getCompanies() {
		return repository.findAll();
	}
	
	public Company findById( int id ) {
		return repository.findById(id).orElse(null);
	}

	public Company updateCompany(Company company) {
		Company existingCompany = repository.findById(company.getId()).orElse(null);
		existingCompany.setTurnOver(company.getTurnOver());
		existingCompany.setCeo(company.getCeo());
		existingCompany.setBoardDirectors(company.getBoardDirectors());
		existingCompany.setBriefWriteup(company.getBriefWriteup());
		return repository.save(existingCompany);
	}
	
	public void deleteCompany(int id) {
		repository.deleteById(id);
	}
	
	public List<Company> searchCompany(String searchString){
		return repository.getCompanyBySearch(searchString);
	}
	

}
