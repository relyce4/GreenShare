package com.greenshare.site.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class Home {
	@RequestMapping
	public String home() {
		return "home.html";
	}
}
