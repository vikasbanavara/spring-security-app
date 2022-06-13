package com.ty.vikas.springsecurityapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.vikas.springsecurityapp.dto.User;
import com.ty.vikas.springsecurityapp.repository.UserRepository;

@RestController
public class HomeController {
	
	@Autowired
	UserRepository repository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public User myHome() {
		User user = new User();
		user.setEmail("dimple@mail.com");
		user.setUserName("Dimple");
		user.setPassword(passwordEncoder.encode("1234"));
		user.setRoles("USER");
		
		return repository.save(user);
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
