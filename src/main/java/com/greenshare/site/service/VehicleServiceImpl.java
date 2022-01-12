package com.greenshare.site.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.greenshare.site.config.CustomProperties;
import com.greenshare.site.entities.Vehicle;
import com.greenshare.site.repo.VehicleDAO;
import com.greenshare.site.util.FileUploadUtil;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO repo;
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		this.repo.save(vehicle);
	}
	
	@Override
	public void addVehicle(Vehicle vehicle, MultipartFile multipartFile) {
		String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		String filename = StringUtils.cleanPath("vehicleImage." + extension);
		
		vehicle.setFilename(filename);
		
		Vehicle newVehicle = this.repo.save(vehicle);

		String uploadDir = CustomProperties.basepath + "/" + newVehicle.getId();
		 
       try {
			FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVehicleById(int id) {
		FileUploadUtil.deleteDir(this.repo.findById(id).get());
		
		this.repo.deleteById(id);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		this.repo.save(vehicle);
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
