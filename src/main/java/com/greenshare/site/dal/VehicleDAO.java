package com.greenshare.site.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenshare.site.entities.Vehicle;

public interface VehicleDAO extends JpaRepository<Vehicle, Integer> {

}
