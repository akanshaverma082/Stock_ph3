package com.example.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Entity.IPODetails;
import com.example.stock.service.IpoService;
import com.example.stock.dto.Ipodto;
import com.example.stock.service.CompanyService;
import com.example.stock.Entity.Company;

@RestController
public class IPODetailsController {
	@Autowired
	IpoService service;
	@Autowired
	CompanyService cservice;
	
	@PostMapping("/addIpo")
	public  ResponseEntity <IPODetails>addIpo(@RequestBody Ipodto ipodto) {
	    IPODetails ipo1=new IPODetails();
	    ipo1.setTotalShares(ipodto.getTotalShares());
	    ipo1.setOpenDateTime(ipodto.getOpenDateTime());
	    ipo1.setRemarks(ipodto.getRemarks());
	    ipo1.setPricePerShare(ipodto.getPricePerShare());
	    Company company=cservice.findByName(ipodto.getCompanyName());
	    if(company!=null)
	    {
	    	ipo1.setCompany(company);
	    	service.saveIpo(ipo1);
	    	company.setIpo(ipo1);
	    	cservice.saveCompany(company);
	    	return new  ResponseEntity<IPODetails>(service.saveIpo(ipo1),HttpStatus.OK);
	    }
	    else
	    	return new  ResponseEntity<IPODetails>(ipo1,HttpStatus.BAD_REQUEST); 
	}
	
	@PutMapping("/updateIpo")
	public IPODetails updateIpo(@RequestBody IPODetails ipo) {
		return service.updateIpo(ipo);
	}
	
	
	@GetMapping("/ipos")
	public List<IPODetails> getIpos(){
		return service.getIpos();
	}
	@DeleteMapping("/deleteIPO/{id}")
	public String deleteIPO(@PathVariable int id) 
	{   
		service.deleteIPO(id);
		return "deleted";
	}
}
