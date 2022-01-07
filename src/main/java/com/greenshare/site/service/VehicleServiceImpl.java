package com.greenshare.site.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.greenshare.site.entities.Vehicle;
import com.greenshare.site.repo.VehicleDAO;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO repo;
	
	@Override
	public void addVehicle(Vehicle a) {
		this.repo.save(a);
	}

	@Override
	public void deleteVehicleById(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public void updateVehicle(Vehicle a) {
		this.repo.save(a);
	}

	@Override
	public List<Vehicle> getVehicles() {
		return this.repo.findAll();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Page<Vehicle> findPaginated(Pageable pageable) {
		List<Vehicle> vehicles = this.repo.findAll();
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Vehicle> list;

        if (vehicles.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, vehicles.size());
            list = vehicles.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), vehicles.size());
	}

}
