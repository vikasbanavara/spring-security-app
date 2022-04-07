package com.ty.vikas.springsecurityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String myHome() {
		return "Hi welcome to home page";
	}
}
