package com.greenshare.site.service;

import java.util.List;

import com.greenshare.site.entities.User;

public interface UserService {
	void addUser(User a);
	void deleteUserById(int id);
	void updateUser(User a);
	List<User> getUsers();
	User getUserByUsername(String username);
	User getUserById(int id);
}
