package com.greenshare.site.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeCtrl {
	@RequestMapping
	public String home() {
		return "homepage";
	}
	
	@RequestMapping("login")
	public String admin() {
		return "login-form";
	}
	
	@RequestMapping("map")
	public String mappa() {
		return "map";
	}

}
