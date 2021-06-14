package com.example.stock.Entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class StockExchange {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false, unique = true)
    private String stockExchangeName;
	
    @Column(nullable = false)
    private String brief;
    
    @Column(nullable = false)
    private String address;
    
    @Column()
    private String remarks;
    
    @ManyToMany
    private List<IPODetails> ipo = new ArrayList<>();
    
    @ManyToMany(mappedBy = "stockExchanges", fetch=FetchType.LAZY)
    private List<Company> companies = new ArrayList<>();
    
    @OneToMany(mappedBy = "stockExchange", fetch=FetchType.LAZY)
    private List<StockPrice> stockPrices = new ArrayList<>();
    
    @OneToOne(mappedBy = "stockExchange")
    private CompanyCode companyCode;

    public StockExchange() {
		super();
	}

	public StockExchange(String stockExchangeName, String brief, String address, String remarks) {
		super();
		this.stockExchangeName = stockExchangeName;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	@JsonBackReference
	public List<IPODetails> getIpo() {
		return ipo;
	}

	public void addIpo(IPODetails ipo) {
		this.ipo.add(ipo);
	}

	@JsonManagedReference
	public List<Company> getCompanies() {
		return companies;
	}

	public void addCompany(Company company) {
		this.companies.add(company);
	}

	@JsonManagedReference
	public List<StockPrice> getStockPrices() {
		return stockPrices;
	}

	public void addStockPrice(StockPrice stockPrice) {
		this.stockPrices.add(stockPrice);
	}

	@JsonManagedReference
	public CompanyCode getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(CompanyCode companyCode) {
		this.companyCode = companyCode;
	}


	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockExchangeName=" + stockExchangeName + ", brief=" + brief + ", address=" + address
				+ ", remarks=" + remarks + "]";
	}

}
