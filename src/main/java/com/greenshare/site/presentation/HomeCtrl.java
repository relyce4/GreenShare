package com.greenshare.site.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greenshare.site.entities.Vehicle;
import com.greenshare.site.service.VehicleService;

@Controller
@RequestMapping("/")
public class HomeCtrl {
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping
	public String home() {
		return "homepage";
	}
	
	@GetMapping("dashboard")
	public String dashboard(Model model) {
		List<Vehicle> vehicles = vehicleService.getVehicles();
		model.addAttribute("vehicles", vehicles);
		return "dashboard";
	}
}
