package com.greenshare.site.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String description;
	private String currentLocation;
	private String imageUrl;
	@OneToOne
	@JoinColumn(name = "id_user")
	private User createdBy;
}