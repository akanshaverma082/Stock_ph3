package com.example.stock.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Entity.Sectors;
import com.example.stock.repository.SectorRepo;
import com.example.stock.Entity.Company;




@Service
public class SectorService {
	@Autowired
	SectorRepo repository;
	
	public Sectors saveSector(Sectors sector) {
		return repository.save(sector);
	}	
	
	public List<Sectors> getSectors() {
		return repository.findAll();
	}
	
	public Sectors findById(int id) {
		return repository.findById(id).orElse(null);
	}

}
