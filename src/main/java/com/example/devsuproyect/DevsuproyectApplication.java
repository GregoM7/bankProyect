package com.example.devsuproyect;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevsuproyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevsuproyectApplication.class, args);
		PropertyConfigurator.configure("log4j.properties");
	}

}
