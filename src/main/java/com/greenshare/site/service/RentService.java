package com.greenshare.site.service;

import java.util.List;

import com.greenshare.site.entities.Rent;

public interface RentService {
    void addRent(Rent rent);
    void deleteRentById(int id);
    void updateRent(Rent rent);
    List<Rent> getRents();
    Rent getRentById(int id);
}
