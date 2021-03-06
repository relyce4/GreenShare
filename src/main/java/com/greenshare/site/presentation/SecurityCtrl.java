package com.greenshare.site.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenshare.site.entities.User;
import com.greenshare.site.form.RegistrationForm;
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
			model.addAttribute("wrongCredentials", true);
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
 
        return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registrazioneForm(RegistrationForm form, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "register";
        }
 
        return "redirect:/";
	}
	
	@PostMapping("/register")
	public String registrazione(@Valid RegistrationForm form, BindingResult error, Model model) {
		
		if(error.hasErrors()) {
			return "register";
		}
		
		User esiste = userService.getUserByUsername(form.getUsername());
		if(esiste != null) {
			error.addError(new FieldError("username","username", "Email gi?? in uso"));
			
			return "register";
		}
		
		User user = form.toUser(passwordEncoder);
		
		userService.addUser(user);
		
		return "redirect:/login";
	}
}
