package com.greenshare.site.service;

import java.util.List;

import com.greenshare.site.entities.User;

public interface UserService {

	
	void addUser(User a);
	void deleteUser(User a);
	void deleteUser(int id);
	void updateUser(User a);
	List<User> getUsers();
	List<User> getUserByUsername(String username);
	User getUserById(int id);

}
