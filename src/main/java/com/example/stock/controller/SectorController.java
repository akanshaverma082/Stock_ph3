package com.example.stock.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Entity.Company;
import com.example.stock.Entity.Sectors;
import com.example.stock.service.SectorService;


@RestController
public class SectorController {
	@Autowired
	SectorService sectorService;
	
	@GetMapping("/getCompaniesFromSectors/{id}")
	public List<Company> getCompanyList(@PathVariable int id){
		Sectors sector = sectorService.findById(id);
		return sector.getCompanies();
	}

}
