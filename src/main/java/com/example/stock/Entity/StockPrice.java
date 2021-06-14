package com.example.stock.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class StockPrice {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private float StockPrice;
	
	@Column(nullable = false)
	private String date;
	
	@Column(nullable = false)
	private String time;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private StockExchange stockExchange;
	
	public float getStockPrice() {
		return StockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.StockPrice = stockPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	@JsonBackReference
	public Company getCompany() {
		return company;
	}

	@JsonBackReference
	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockPrice( float stockPrice, String date, String time) {
		super();
		StockPrice = stockPrice;
		this.date = date;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", stockPrice="
				+ StockPrice + ", date=" + date + ", time=" + time + "]";
	}	

}
