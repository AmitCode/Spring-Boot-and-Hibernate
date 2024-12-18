package com.springWeb.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Spring Boot Web App Started!...");
		return "home";
	}

}
