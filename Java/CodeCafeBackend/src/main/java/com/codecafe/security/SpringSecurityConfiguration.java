package com.codecafe.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfiguration {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated()); //Checking if all requests are authorized
		http.httpBasic(Customizer.withDefaults()); //popup instead of webpage for signin
		http.csrf(csrf->csrf.disable()); //disable csrf to enable put and post
		return http.build();
		
	}
}
