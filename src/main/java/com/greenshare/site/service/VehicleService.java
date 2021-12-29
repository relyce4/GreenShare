package com.greenshare.site.service;

import java.util.List;

import com.greenshare.site.entities.Vehicle;

public interface VehicleService {
	void addVehicle(Vehicle a);
	void deleteVehicleById(int id);
	void updateVehicle(Vehicle a);
	List<Vehicle> getVehicles();
	Vehicle getVehicleById(int id);
}