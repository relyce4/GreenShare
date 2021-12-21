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
		// TODO Auto-generated method stub
		this.repo.save(a);
	}

	@Override
	public void deleteVehicle(Vehicle a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVehicle(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateVehicle(Vehicle a) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vehicle> getVehicles() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

}
