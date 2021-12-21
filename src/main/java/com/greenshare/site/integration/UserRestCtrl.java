package com.greenshare.site.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenshare.site.entities.User;
import com.greenshare.site.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserRestCtrl {

	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> getAll() {
		return this.service.getUsers();	
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable("id") int id) {
		return this.service.getUserById(id);
	}
	
	@GetMapping("/{email}")
	public List<User> getAllByEmail(@PathVariable String email) {
		return this.service.getUserByEmail(email);
	}

	@PostMapping(consumes = "application/json")
	public void addOne(@RequestBody User a) {
		this.service.addUser(a);
	}
}
