package com.greenshare.site.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenshare.site.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
