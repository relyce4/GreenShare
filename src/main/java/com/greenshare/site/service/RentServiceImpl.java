package com.greenshare.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenshare.site.entities.Rent;
import com.greenshare.site.repo.RentDAO;

@Service
public class RentServiceImpl implements RentService {
	@Autowired
	RentDAO repo;

	@Override
	public void addRent(Rent rent) {
		this.repo.save(rent);
	}

	@Override
	public void deleteRentById(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public void updateRent(Rent rent) {
		this.repo.save(rent);
	}

	@Override
	public List<Rent> getRents() {
		return this.repo.findAll();
	}

	@Override
	public Rent getRentById(int id) {
		return this.repo.findById(id).get();
	}
}
