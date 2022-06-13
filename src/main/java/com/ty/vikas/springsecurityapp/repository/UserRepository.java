package com.ty.vikas.springsecurityapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.vikas.springsecurityapp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public Optional<User> findByEmail(String email);
}
