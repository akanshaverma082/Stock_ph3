package com.example.stock;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.stock.Entity.Company;
import com.example.stock.Entity.CompanyCode;
import com.example.stock.Entity.IPODetails;
import com.example.stock.Entity.Sectors;
import com.example.stock.Entity.StockExchange;
import com.example.stock.Entity.StockPrice;
import com.example.stock.repository.CompanyCodeRepo;
import com.example.stock.repository.CompanyRepo;
import com.example.stock.repository.IpoRepo;
import com.example.stock.repository.SectorRepo;
import com.example.stock.repository.StockExchangeRepo;
import com.example.stock.repository.StockPriceRepo;



@SpringBootApplication
public class Stock2Application implements CommandLineRunner {

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SectorRepo sectorRespository;
	
	@Autowired
	StockPriceRepo stockPriceRepository;
	
	@Autowired
	StockExchangeRepo stockExchangeRepository;
	
	@Autowired
	IpoRepo ipoRepository;
	
	@Autowired
	CompanyRepo companyRepository;
	
	@Autowired
	CompanyCodeRepo companyCodeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Stock2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Sectors sector = new Sectors(" Sector1", "It takes care of health problems");
		sectorRespository.save(sector);
		
		StockExchange stockExchange = new StockExchange("BSE", "Primary", "Boring Road", "Very Imp");
		stockExchangeRepository.save(stockExchange);
		
		StockExchange stockExchange1 = new StockExchange("NSE", "Primary", "Bailey Road", "Highly Critical");
		stockExchangeRepository.save(stockExchange1);
		
		StockPrice stockPrice = new StockPrice((float)25.15, "20-8-15", "9:13 AM");
		stockPrice.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice);
		
		IPODetails ipo = new IPODetails((float)10, 150L, "22-2-2015, 11:15 AM", "High valued!");
		IPODetails ipo1 = new IPODetails((float)100, 200L, "23-2-2020, 12:15 AM", "High valued!");
		ipoRepository.save(ipo);
		ipoRepository.save(ipo1);
		
		Company company = new Company("company1", (float)200000000, "Ankita", "Ankit, Sanaya, Mahesh ", "It is working well.", ipo, Arrays.asList(stockExchange), Arrays.asList(stockPrice), sector);
		companyRepository.save(company);
		
		Company company1 = new Company("company2", (float)200000000, "Riya", "Rahul , Anshu, Aashu", "It is working fine");
		company1.addStockExchange(stockExchange1);
		company1.addStockExchange(stockExchange);
		company1.setSector(sector);
		company1.setIpo(ipo1);
		companyRepository.save(company1);
		

		
		stockExchange.addIpo(ipo);
		stockExchangeRepository.save(stockExchange);
		
		CompanyCode companyCode = new CompanyCode(60101);
		companyCode.setCompany(company);
		companyCode.setStockExchange(stockExchange);
		companyCodeRepository.save(companyCode);
		
		stockPrice.setCompanyCode(companyCode);
		stockPriceRepository.save(stockPrice);

	}

}
