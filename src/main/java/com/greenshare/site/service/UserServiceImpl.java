package com.greenshare.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenshare.site.dal.UserDAO;
import com.greenshare.site.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO repo;
	
	@Override
	public void addUser(User a) {
		this.repo.save(a);
	}

	@Override
	public void deleteUserById(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public void updateUser(User a) {
		this.repo.save(a);
	}

	@Override
	public List<User> getUsers() {
		return this.repo.findAll();
	}

	@Override
	public List<User> getUserByEmail(String email) {
		return this.repo.findByEmail(email);
	}

	@Override
	public User getUserById(int id) {
		return this.repo.findById(id).get();
	}

}
