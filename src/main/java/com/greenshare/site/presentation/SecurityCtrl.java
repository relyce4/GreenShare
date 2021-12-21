package com.greenshare.site.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenshare.site.service.UserService;

@Controller
public class SecurityCtrl {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String loginForm(@RequestParam(required = false) String error, Model model) {
		if("true".equals(error)) {
			model.addAttribute("message", true);
		}
		
		return "login-form";
	}
}
