package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	

	@Bean
	public SecurityFilterChain getSecurityFilterChain( HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf(customizer -> customizer.disable());
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		httpSecurity.formLogin(Customizer.withDefaults());
		return httpSecurity.build();
	}
}
