package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
	
	//for window
	//static final public String savePath = "c:/upload/";
	
	//for linux
	static final public String savePath = "/usr/upload";
	

	
//	<resources mapping="/upload/**" location=">
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//for window
		//registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");
		//WebMvcConfigurer.super.addResourceHandlers(registry);
		
		//for linux
		registry.addResourceHandler("/upload/**").addResourceLocations("file:/usr/upload/");
		
	}
}