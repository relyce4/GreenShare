package com.greenshare.site.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenshare.site.entities.Vehicle;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, Integer> {

}
