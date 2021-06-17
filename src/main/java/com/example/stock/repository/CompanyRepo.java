package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.stock.Entity.Company;


public interface CompanyRepo extends JpaRepository<Company, Integer> {
	@Query("SELECT c FROM COMPANY c WHERE c.companyName LIKE %?1%")
	public List<Company> getCompanyBySearch(String searchString);
	

}
