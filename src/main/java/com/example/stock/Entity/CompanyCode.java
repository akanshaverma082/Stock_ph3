package com.example.stock.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class CompanyCode {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private int companyCode;
	
	@ManyToOne
	private Company company;
	
	@OneToOne
	private StockExchange stockExchange;

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	@JsonBackReference
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonBackReference
	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public CompanyCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyCode(int companyCode) {
		super();
		this.companyCode = companyCode;
	}

}
