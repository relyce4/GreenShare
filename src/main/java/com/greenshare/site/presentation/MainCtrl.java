package com.greenshare.site.presentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenshare.site.entities.Rent;
import com.greenshare.site.entities.User;
import com.greenshare.site.entities.Vehicle;
import com.greenshare.site.service.RentService;
import com.greenshare.site.service.VehicleService;

@Controller
@RequestMapping("/")
public class MainCtrl {
	@Autowired
	VehicleService vehicleService;

	@Autowired
	RentService rentService;

	@ModelAttribute
	public void addAttributes(Model model) {
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (user != "anonymousUser") {
			User loggedUser = (User) user;
			model.addAttribute("loggedUser", loggedUser);
		}
	}

	@GetMapping
	public String home(Model model) {
		List<Vehicle> vehicles = vehicleService.getVehicles();

		model.addAttribute("vehicles", vehicles);

		return "homepage";
	}

	@GetMapping("dashboard")
	public String dashboard(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(10);
		
		Page<Vehicle> vehiclePage = vehicleService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
		
		model.addAttribute("vehiclePage", vehiclePage);
		
		int totalPages = vehiclePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
		
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
		List<Rent> rents = rentService.getRents();

		model.addAttribute("vehicles", vehicles);
		model.addAttribute("rents", rents);

		return "map";
	}

	@GetMapping("rents")
	public String rents(Model model) {
		List<Rent> rents = rentService.getRents();

		model.addAttribute("rents", rents);

		return "rents";
	}
}
