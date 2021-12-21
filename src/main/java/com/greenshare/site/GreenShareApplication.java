package com.greenshare.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
public class GreenShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenShareApplication.class, args);
	}

}
