package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.Sectors;
import com.example.stock.Entity.Company;
import java.util.List;


public interface SectorRepo extends JpaRepository<Sectors, Integer>{

}
