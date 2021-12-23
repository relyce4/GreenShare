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
	
	@RequestMapping("admin")
	public String admin() {
		return "";
	}
}
