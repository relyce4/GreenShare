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
		// TODO Auto-generated method stub
		this.repo.save(a);
	}

	@Override
	public void deleteUser(User a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public List<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return this.repo.findByUsername(username);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

}
