package com.example.stock.controller;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Entity.Company;
import com.example.stock.Entity.IPODetails;
import com.example.stock.service.CompanyService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stockcompany")
public class CompanyController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CompanyService service;
	
	@PostMapping("/addCompany")
	public ResponseEntity <Company>addCompany(@RequestBody Company company) {
		boolean uniqueCompanyName = service.CompanyNameUniq(company.getCompanyName());
		if(!uniqueCompanyName) {
			return new  ResponseEntity<Company>(company,HttpStatus.BAD_REQUEST);
		} 
		else {
			service.saveCompany(company);
			return new  ResponseEntity<Company>(service.saveCompany(company),HttpStatus.OK);
			
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Company>DeleteCompany(@PathVariable int id) 
	{
		Company co1=service.findById(id);
		if(co1!=null)
		{
		service.deleteCompany(id);
      return new  ResponseEntity<Company>(HttpStatus.OK);
		}
		else
		{
			 return new  ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
		}
		
	}

	
	
	@PutMapping("/updateCompany/{id}")
	public  ResponseEntity <Company>addCompany(@RequestBody Company company,@PathVariable int id) {
		Company co1=service.findById(id);
		if(co1!=null) {
		return new  ResponseEntity<Company>(service.updateCompany(company, id),HttpStatus.OK);
		}
		else
		{
			return new  ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//@GetMapping("/getCompany/{id}")
	//public Company getCompany(@PathVariable int id) {
		//return service.findById(id);
	//}
	@GetMapping("/getCompany/{id}")
	public  ResponseEntity <Company>getCompanybyid(@PathVariable int id)
	{
		Company co=service.findById(id);
		if(co!=null)
		return new  ResponseEntity<Company>(service.findById(id),HttpStatus.OK);
		else
			return new  ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
			
	}
	
	
	@GetMapping("/getCompanybyname/{companyName}")
	public Company getCompanybyname(@PathVariable String companyName)
	{
		return service.findByName(companyName);
	}
	
	@GetMapping("/getIpoFromCompany/{id}")
	public IPODetails getIpoFromCompany(@PathVariable int id) {
		Company company = service.findById(id);
		return company.getIpo();
	}	
	
	@GetMapping("/searchCompany/{searchString}")
	public List<Company> searchCompany(@PathVariable String searchString) {
		return service.searchCompany(searchString);
	}
	@GetMapping("/companies")
	public List<Company> getCompanies(){
		return service.getCompanies();
	}
}
