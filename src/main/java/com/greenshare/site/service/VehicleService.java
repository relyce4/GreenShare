package com.greenshare.site.service;

import java.util.List;

import com.greenshare.site.entities.Vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface VehicleService {
	void addVehicle(Vehicle vehicle);
	void addVehicle(Vehicle vehicle, MultipartFile multipartfile);
	void deleteVehicleById(int id);
	void updateVehicle(Vehicle vehicle);
	List<Vehicle> getVehicles();
	Vehicle getVehicleById(int id);
	Page<Vehicle> findPaginated(Pageable pageable);
}