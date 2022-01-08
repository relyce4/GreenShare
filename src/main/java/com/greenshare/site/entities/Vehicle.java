package com.greenshare.site.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.greenshare.site.config.CustomProperties;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String description;
	private String coordinates;
	private String currentLocation;
	private String filename;
	private int battery;
	private int maxAutonomy;
	private double pricePerMinute;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creationDate = new java.util.Date();
	
    public String getImageUrl() {
		// 1) percorso immagine di default se non è stata caricata
		// 2) percorso immagine caricata

		if (filename == null || filename.equals("")) {
        	//1
        	return "/" + CustomProperties.defaultImg;        	
        }
        //2
        return "/" + CustomProperties.baseurl + "/" + id + "/" + filename;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public int getMaxAutonomy() {
		return maxAutonomy;
	}
	public void setMaxAutonomy(int maxAutonomy) {
		this.maxAutonomy = maxAutonomy;
	}
	public double getPricePerMinute() {
		return pricePerMinute;
	}
	public void setPricePerMinute(double pricePerMinute) {
		this.pricePerMinute = pricePerMinute;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}