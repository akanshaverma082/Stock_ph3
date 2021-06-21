package com.example.stock.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Entity.IPODetails;
import com.example.stock.repository.IpoRepo;
@Service
public class IpoService {
	@Autowired
	IpoRepo repository;
	
	public IPODetails saveIpo(IPODetails ipo) {
		return repository.save(ipo);
	}
	
	public IPODetails updateIpo(IPODetails ipo) {
		IPODetails existingIpo = repository.findById(ipo.getId()).orElse(null);
		existingIpo.setPricePerShare(ipo.getPricePerShare());
		existingIpo.setTotalShares(ipo.getTotalShares());
		existingIpo.setOpenDateTime(ipo.getOpenDateTime());
		existingIpo.setRemarks(ipo.getRemarks());
		return repository.save(existingIpo);
	}
	public void deleteIPO(int id) {
		repository.deleteById(id);
	}
	
	public List<IPODetails> getIpos() {
		return repository.findAll();
	}

}
