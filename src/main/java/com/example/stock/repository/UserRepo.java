package com.example.stock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.Entity.Users;


public interface UserRepo extends JpaRepository<Users, Integer> {

}
