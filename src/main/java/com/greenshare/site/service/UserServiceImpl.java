package com.greenshare.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greenshare.site.entities.User;
import com.greenshare.site.repo.UserDAO;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDAO repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User " + username + " not found!");
		}

		return user;
	}
	
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
	public User getUserByUsername(String username) {
		return this.repo.findByUsername(username);
	}

	@Override
	public User getUserById(int id) {
		return this.repo.findById(id).get();
	}
}
