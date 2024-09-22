package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	

	@Bean
	public SecurityFilterChain getSecurityFilterChain( HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf(customizer -> customizer.disable());
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		httpSecurity.formLogin(Customizer.withDefaults());// for UI page Access if we comment then form login will not show
		httpSecurity.httpBasic(Customizer.withDefaults());//for postman or other tools access
		httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return httpSecurity.build();
	}
	
	//Manual user Name password
	/*
	 * @Bean public UserDetailsService userDetailsService() {
	 * 
	 * UserDetails user1 =
	 * User.withDefaultPasswordEncoder().username("amrit").password("1234")
	 * .roles("USER").build();
	 * 
	 * return new InMemoryUserDetailsManager(user1); }
	 */
}
