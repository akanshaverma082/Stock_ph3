package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.IPODetails;


public interface IpoRepo extends JpaRepository<IPODetails, Integer>{

}
