package com.greenshare.site.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@GetMapping
	public String home() {
		return "homepage";
	}
	
	@GetMapping("dashboard")
	public String dashboard(HttpServletRequest request, Model model) {
		List<Vehicle> vehicles = vehicleService.getVehicles();
		User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("loggedUser", loggedUser);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("vehicleModel", new Vehicle());
		return "dashboard";
	}
	
	@PostMapping("update/vehicle")
	public String dashboard(@ModelAttribute Vehicle vehicle, Model model) {
		vehicleService.updateVehicle(vehicle);
		return "redirect:/dashboard";
	}
}
