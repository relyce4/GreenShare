package com.greenshare.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenshare.site.dal.VehicleDAO;
import com.greenshare.site.entities.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO repo;
	
	
	@Override
	public void addVehicle(Vehicle a) {
		this.repo.save(a);
	}

	@Override
	public void deleteVehicleById(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public void updateVehicle(Vehicle a) {
		this.repo.save(a);
	}

	@Override
	public List<Vehicle> getVehicles() {
		return this.repo.findAll();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return this.repo.findById(id).get();
	}

}
