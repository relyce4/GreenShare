package com.greenshare.site.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public User getUserById(@PathVariable int id) {
		return this.service.getUserById(id);
	}
	
	@GetMapping("/{username}")
	public User getByUsername(@PathVariable String username) {
		return this.service.getUserByUsername(username);
	}

	@PostMapping(consumes = "application/json")
	public void addUser(@RequestBody User a) {
		this.service.addUser(a);
	}
	@PutMapping(value = "update", consumes = "application/json")
	public void updateUser (@RequestBody User a) {
		this.service.updateUser(a);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public void deleteUserById(@PathVariable int id) {
		this.service.deleteUserById(id);
	}
}
