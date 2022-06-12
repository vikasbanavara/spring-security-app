package com.ty.vikas.springsecurityapp.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("vikas")
		.password(passwordEncoder().encode("vikas"))
		.roles("USER")
		.and()
		.withUser("pooja")
		.password(passwordEncoder().encode("pooja"))
		.roles("ADMIN");
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/").permitAll()
		.and().httpBasic();
	}
	
	
	
	
}
