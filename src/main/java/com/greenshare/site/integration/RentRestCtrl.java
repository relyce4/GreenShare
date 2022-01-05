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
import org.springframework.web.bind.annotation.RestController;

import com.greenshare.site.entities.Rent;
import com.greenshare.site.service.RentService;

@RestController
@RequestMapping("api/rents")
public class RentRestCtrl {

	@Autowired
	private RentService service;
	
	@GetMapping
	public List<Rent> getAll() {
		return this.service.getRents();	
	}
	
	@GetMapping("/{id}")
	public Rent getRentById(@PathVariable int id) {
		return this.service.getRentById(id);
	}

	@PostMapping(value = "add", consumes = "application/json")
	public void addRent(@RequestBody Rent rent) {
		this.service.addRent(rent);
	}

	@PutMapping(value = "update", consumes = "application/json")
	public void updateRent (@RequestBody Rent rent) {
		this.service.updateRent(rent);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public void deleteRentById(@PathVariable int id) {
		this.service.deleteRentById(id);
	}
}
