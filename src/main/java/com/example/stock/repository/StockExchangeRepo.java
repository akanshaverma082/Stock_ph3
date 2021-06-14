package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.StockExchange;

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer> {

}
