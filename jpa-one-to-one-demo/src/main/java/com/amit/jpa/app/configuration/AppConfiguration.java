package com.amit.jpa.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amit.jpa.service.AppService;

/**
*
* @author Amit Patil
*
**/
@Configuration
public class AppConfiguration {

	@Bean
	public AppService appService() {
		return new AppService();
	}
}
