package com.example.stock.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Entity.Users;
import com.example.stock.repository.UserRepo;


@Service
public class UserService {
	
	@Autowired
	UserRepo repository;
	
	public Users saveUser(Users user) {
		return repository.save(user);
	}
	

}
