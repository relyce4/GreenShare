package com.greenshare.site.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greenshare.site.entities.Vehicle;
import com.greenshare.site.service.VehicleService;

public class VehicleRestCtrl {

	@Autowired
	private VehicleService service;
	
	@GetMapping
	public List<Vehicle> getAll() {
		return this.service.getVehicles();	
	}
	
	@GetMapping("/{id}")
	public Vehicle getById(@PathVariable("id") int id) {
		return this.service.getVehicleById(id);
	}
	
	@PostMapping(consumes = "application/json")
	public void addOne(@RequestBody Vehicle a) {
		this.service.addVehicle(a);
	}
	
	
	
	
	
	
}
