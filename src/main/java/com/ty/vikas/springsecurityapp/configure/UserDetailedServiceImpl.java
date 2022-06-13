package com.ty.vikas.springsecurityapp.configure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ty.vikas.springsecurityapp.dto.User;
import com.ty.vikas.springsecurityapp.repository.UserRepository;
import com.ty.vikas.springsecurityapp.util.UserDetailsImpl;

@Service
public class UserDetailedServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> optional = repository.findByEmail(email);
		if(optional.isEmpty()) {
			return null;
		} else {
			return new UserDetailsImpl(optional.get());
		}
		
	}

}
