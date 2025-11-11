package com.yedam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.yedam.exam.Chef;
import com.yedam.exam.Restaurant;

@Configuration
@ComponentScan(basePackages = { "com.yedam" })
public class RootConfig {

	@Bean 
	public Chef chef() { 
		return new Chef(); 
	}
	 
	@Bean 
	@Scope("prototype")
	public Restaurant restaurant() { 
		return new Restaurant(chef()); 
	}

}
