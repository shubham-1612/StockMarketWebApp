package com.training.shubham.stockmarketwebapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
	
	@Bean
	public MyUserDetailsService myUserDetailsService() {
		MyUserDetailsService myUserDetailsService = new MyUserDetailsService();
		return myUserDetailsService;
	}
	
	@Bean
	public JwtRequestFilter jwtRequestFilter() {
		JwtRequestFilter jwtRequestFilter = new JwtRequestFilter();
		return jwtRequestFilter;
	}
}
