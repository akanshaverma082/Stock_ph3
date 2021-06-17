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
		Sectors sector = new Sectors("Heath Sector", "It takes care of the problems");
		sectorRespository.save(sector);
		
		StockExchange stockExchange = new StockExchange("BSE", "Primary", "7th Street, near New Mall, Bombay", "Very Important");
		stockExchangeRepository.save(stockExchange);
		
		StockExchange stockExchange1 = new StockExchange("NSE", "Primary", "8th Street, near New Mall, Bombay", "Very Critical");
		stockExchangeRepository.save(stockExchange1);
		
		StockPrice stockPrice = new StockPrice((float)20.12, "20-2-12", "8:13 AM");
		stockPrice.setStockExchange(stockExchange);
		stockPriceRepository.save(stockPrice);
		
		IPODetails ipo = new IPODetails((float)10, 100L, "20-2-2013, 9:15 AM", "High valued!");
		IPODetails ipo1 = new IPODetails((float)100, 200L, "20-2-2021, 10:15 AM", "Mid valued!");
		ipoRepository.save(ipo);
		ipoRepository.save(ipo1);
		
		Company company = new Company("company1", (float)200000000, "Mahesh Singh", "Rahul Bisnoy, Ashu Bisig, Mahesh Singh", "It is working pretty well.", ipo, Arrays.asList(stockExchange), Arrays.asList(stockPrice), sector);
		companyRepository.save(company);
		
		Company company1 = new Company("company2", (float)200000000, "Mahesh Singh1", "Rahul Bisnoy1, Ashu Bisig1, Mahesh Singh1", "It is working pretty well.1");
		company1.addStockExchange(stockExchange1);
		company1.addStockExchange(stockExchange);
		company1.setSector(sector);
		company1.setIpo(ipo1);
		companyRepository.save(company1);
		

		
		stockExchange.addIpo(ipo);
		stockExchangeRepository.save(stockExchange);
		
		CompanyCode companyCode = new CompanyCode(500101);
		companyCode.setCompany(company);
		companyCode.setStockExchange(stockExchange);
		companyCodeRepository.save(companyCode);
		
		stockPrice.setCompanyCode(companyCode);
		stockPriceRepository.save(stockPrice);

	}

}
