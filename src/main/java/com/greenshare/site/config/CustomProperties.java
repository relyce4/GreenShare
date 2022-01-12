package com.greenshare.site.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomProperties {
	public static String basepath = "src/main/resources/static/immagini/upload";
	public static String baseurl = "immagini/upload";
	
	public static String defaultImg = "immagini/carDefault.png";
}
