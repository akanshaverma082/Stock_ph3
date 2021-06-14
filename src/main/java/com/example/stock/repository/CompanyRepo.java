package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.Company;


public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
