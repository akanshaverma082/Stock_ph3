package com.example.stock.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Entity.StockPrice;
import com.example.stock.repository.StockPriceRepo;
@Service
public class StockPriceService {
	@Autowired
	StockPriceRepo repository;

	public StockPrice saveStockPrice(StockPrice stockPrice) {
		return repository.save(stockPrice);
	}
}
