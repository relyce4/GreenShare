package com.greenshare.site.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.greenshare.site.entities.Rent;

public interface RentDAO extends JpaRepository<Rent, Integer> {
    
}
