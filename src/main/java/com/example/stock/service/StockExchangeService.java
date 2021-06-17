package com.example.stock.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Entity.StockExchange;
import com.example.stock.repository.StockExchangeRepo;

@Service
public class StockExchangeService {
	@Autowired
	StockExchangeRepo repository;
	
	public StockExchange saveStockExchange (StockExchange stockExchange) {
		return repository.save(stockExchange);
	}
	
	public StockExchange getByStockExchangeName (String stockExchangeName) {
		return repository.findByStockExchangeName(stockExchangeName);
	}
	
	public List<StockExchange> getAllStockExchanges () {
		return repository.findAll();
	}
	
	public StockExchange findById(int id) {
		return repository.findById(id).orElse(null);
	}
}
