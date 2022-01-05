package com.greenshare.site.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.greenshare.site.entities.Rent;
import com.greenshare.site.entities.User;
import com.greenshare.site.entities.Vehicle;

public interface RentDAO extends JpaRepository<Rent, Integer> {
    
}
