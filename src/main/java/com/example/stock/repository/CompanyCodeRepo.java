package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.CompanyCode;

public interface CompanyCodeRepo extends JpaRepository<CompanyCode, Integer> {
	CompanyCode findByCompanyCode(int companyCode);

}
