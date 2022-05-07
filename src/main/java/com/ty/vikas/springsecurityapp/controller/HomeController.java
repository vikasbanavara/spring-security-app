package com.ty.vikas.springsecurityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String myHome() {
		return "Hi welcome to home page";
	}
	
	@GetMapping("/admin")
	public String myAdmin() {
		return "Hi welcome to admin page";
	}
	
	@GetMapping("/user")
	public String myUser() {
		return "Hi welcome to user page";
	}
}
