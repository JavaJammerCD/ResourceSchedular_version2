package com.bod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ResourceSchedulerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(ResourceSchedulerApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ResourceSchedulerApplication.class, args);
	}
}
