package com.greenshare.site.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.greenshare.site.entities.Vehicle;
import com.greenshare.site.service.VehicleService;

@RestController
@RequestMapping("api/vehicles")
public class VehicleRestCtrl {

	@Autowired
	private VehicleService service;
	
	@GetMapping
	public List<Vehicle> getAll() {
		return this.service.getVehicles();
	}
	
	@GetMapping("/{id}")
	public Vehicle getVehicleById(@PathVariable int id) {
		return this.service.getVehicleById(id);
	}
	
	@PostMapping("add")
	public void addVehicle(Vehicle vehicle, @RequestParam(name = "image", required = false) MultipartFile multipartfile) {
		if (multipartfile == null || multipartfile.isEmpty()) {
			this.service.addVehicle(vehicle);
		} else {
			this.service.addVehicle(vehicle, multipartfile);
		}
	}
	
	@PutMapping(value = "update", consumes = "application/json")
	public void updateVehicle (@RequestBody Vehicle vehicle) {
		this.service.updateVehicle(vehicle);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public void deleteVehicleById(@PathVariable int id) {
		this.service.deleteVehicleById(id);
	}
}
