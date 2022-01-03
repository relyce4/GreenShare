package com.greenshare.site.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greenshare.site.entities.User;
import com.greenshare.site.entities.Vehicle;
import com.greenshare.site.service.VehicleService;

@Controller
@RequestMapping("/")
public class MainCtrl {
	@Autowired
	VehicleService vehicleService;
	
	@ModelAttribute
	public void addAttributes(Model model) {
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (user != "anonymousUser") {
			User loggedUser = (User) user;
			model.addAttribute("loggedUser", loggedUser);
		}
	}

	@GetMapping
	public String home() {
		return "homepage";
	}
	
	@GetMapping("dashboard")
	public String dashboard(Model model) {
		List<Vehicle> vehicles = vehicleService.getVehicles();

		model.addAttribute("vehicles", vehicles);
		model.addAttribute("vehicleModel", new Vehicle());
		
		return "dashboard";
	}
	
	@PostMapping("update/vehicle")
	public String dashboard(@ModelAttribute Vehicle vehicle, Model model) {
		vehicleService.updateVehicle(vehicle);

		return "redirect:/dashboard";
	}

	@GetMapping("map")
	public String map(Model model) {
		List<Vehicle> vehicles = vehicleService.getVehicles();

		model.addAttribute("vehicles", vehicles);

		return "map";
	}
}
