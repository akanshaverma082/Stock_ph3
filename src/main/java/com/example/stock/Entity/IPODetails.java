package com.example.stock.Entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class IPODetails {
	@Id
	@GeneratedValue
	private int	id;
	
	@Column(nullable = false)
	private	float pricePerShare;
	
	@Column(nullable = false)
	private	float totalShares;
	
	@Column(nullable = false)
	private	String openDateTime;
	
	@Column(nullable = false)
	private String remarks;
	
	@OneToOne(mappedBy="ipo", fetch=FetchType.LAZY)
	private	Company company;
	
	@ManyToMany(mappedBy="ipo", fetch=FetchType.LAZY)
	private List<StockExchange> stockExchanges = new ArrayList<>();

	public IPODetails() {
		super();
	}

	public IPODetails(float pricePerShare, float totalShares, String openDateTime, String remarks) {
		super();
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}

	public float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public float getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(Long totalShares) {
		this.totalShares = totalShares;
	}

	public String getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(String openDateTime) {
		this.openDateTime = openDateTime;
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

	@JsonManagedReference
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonManagedReference
	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}
	
	public void addStockExchange(StockExchange stockExchange) {
		stockExchanges.add(stockExchange);
	}
	
	@Override
	public String toString() {
		return "IPODetails [id=" + id + ", pricePerShare=" + pricePerShare + ", totalShares=" + totalShares
				+ ", openDateTime=" + openDateTime + ", remarks=" + remarks + "]";
	}


}
