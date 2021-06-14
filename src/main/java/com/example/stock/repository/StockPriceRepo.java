package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.StockPrice;

public interface StockPriceRepo extends JpaRepository<StockPrice, Integer> {
	

}
