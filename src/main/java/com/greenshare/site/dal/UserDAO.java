package com.greenshare.site.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenshare.site.entities.User;
import com.greenshare.site.entities.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);
}
