package com.example.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Entity.IPODetails;
import com.example.stock.service.IpoService;

@RestController
public class IPODetailsController {
	@Autowired
	IpoService service;
	
	@PostMapping("/addIpo")
	public String addIpo(@RequestBody IPODetails ipo) {
	    HashMap<String, String> map = new HashMap<>();
	    
	         return "okay";
	}
	
	@PutMapping("/updateIpo")
	public IPODetails updateIpo(@RequestBody IPODetails ipo) {
		return service.updateIpo(ipo);
	}
	
	@GetMapping("/ipos")
	public List<IPODetails> getIpos(){
		return service.getIpos();
	}
}
