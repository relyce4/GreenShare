package com.greenshare.site.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greenshare.site.entities.User;

public class RegistrationForm {
	@Email
	@NotBlank
	@Length(min = 5, max=30)
	private String username;
	
	@NotBlank
	@Length(min = 4, max=30)
	private String password;
	
	
	public User toUser(PasswordEncoder passwordEncoder) {		
		User user =  new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		
		return user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
