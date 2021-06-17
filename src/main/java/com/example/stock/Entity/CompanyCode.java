package com.example.stock.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@OneToOne(mappedBy = "companyCode", fetch=FetchType.LAZY)
	private StockPrice stockPrice;
	
	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	@JsonBackReference(value = "companyCode-company")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonBackReference(value = "companyCode-stockExchange")
	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	@JsonManagedReference(value = "stockPrice-companyCode")
	public StockPrice getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(StockPrice stockPrice) {
		this.stockPrice = stockPrice;
	}

	public CompanyCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyCode(int companyCode) {
		super();
		this.companyCode = companyCode;
	}

	@Override
	public String toString() {
		return "CompanyCode [id=" + id + ", companyCode=" + companyCode + ", company=" + company + ", stockExchange="
				+ stockExchange + ", stockPrice=" + stockPrice + "]";
	}
	

}
