package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.Sectors;


public interface SectorRepo extends JpaRepository<Sectors, Integer>{

}
