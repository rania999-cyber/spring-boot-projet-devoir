package com.example.springbootprojetdevoir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
 @ComponentScan(basePackages = {"com.example.springbootprojetdevoir", "com.example.springbootprojetdevoir.config"})
public class SpringBootProjetDevoirApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjetDevoirApplication.class, args);
	}

}